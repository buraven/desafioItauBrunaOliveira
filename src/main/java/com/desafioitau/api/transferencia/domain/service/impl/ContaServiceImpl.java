package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.ContaService;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContaServiceImpl implements ContaService {

    private final Map<String, ContaResponseDTO> CACHE = new HashMap<>();

    @Override
    @CircuitBreaker(name = "buscarContaPorIdCB", fallbackMethod = "buscarContaPorIdNoCache")
    public ContaResponseDTO buscarContaPorId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ContaResponseDTO> response = restTemplate
                .getForEntity("http://localhost:9090/contas/" + id, ContaResponseDTO.class);

        return response.getBody();
    }

    @Override
    @CircuitBreaker(name = "atualizarSaldoCB")
    public void atualizarSaldo(SaldoRequestDTO saldoRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate
                .put("http://localhost:9090/contas/saldos", saldoRequestDTO);
    }

    private ContaResponseDTO buscarContaPorIdNoCache(String id) {
        return CACHE.getOrDefault(id, new ContaResponseDTO());
    }

}