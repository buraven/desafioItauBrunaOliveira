package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.CircuitBreakerLogConfig;
import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class CadastroServiceImpl implements CadastroService {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);
    private final RestTemplate restTemplate;

    private final Map<String, ClienteResponseDTO> CACHE = new HashMap<>();

    public CadastroServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @CircuitBreaker(name = "buscarClientePorIdCB", fallbackMethod = "buscarClientePorIdNoCache")
    public ClienteResponseDTO buscarClientePorId(String id) {
        return executarRequisicao(id);
    }

    private ClienteResponseDTO executarRequisicao(String id) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/clientes/" + id)
                .encode()
                .toUriString();

        logger.info("Buscando cliente por id");
        final ClienteResponseDTO clienteResponseDTO;
        try {
            clienteResponseDTO = restTemplate
                    .getForEntity(API_URL, ClienteResponseDTO.class)
                    .getBody();
        } catch (Exception e) {
            logger.error("Erro ao buscar cliente por id");
            throw e;
        }

        logger.info("Populando cache");
        CACHE.put(id, clienteResponseDTO);

        return clienteResponseDTO;
    }

    private ClienteResponseDTO buscarClientePorIdNoCache(String id) {
        return CACHE.getOrDefault(id, new ClienteResponseDTO());
    }

}