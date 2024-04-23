package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CadastroServiceImpl implements CadastroService {

    private final Map<String, ClienteResponseDTO> CACHE = new HashMap<>();

    @Override
    @CircuitBreaker(name = "buscarClientePorIdCB", fallbackMethod = "buscarClientePorIdNoCache")
    public ClienteResponseDTO buscarClientePorId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ClienteResponseDTO> response = restTemplate
                .getForEntity("http://localhost:9090/clientes/" + id, ClienteResponseDTO.class);

        CACHE.put(id, response.getBody());

        return response.getBody();
    }

    private ClienteResponseDTO buscarClientePorIdNoCache(String id) {
        return CACHE.getOrDefault(id, new ClienteResponseDTO());
    }

}