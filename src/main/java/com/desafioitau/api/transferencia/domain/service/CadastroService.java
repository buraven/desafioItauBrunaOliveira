package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.model.ClienteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class CadastroService implements com.desafioitau.api.transferencia.domain.repository.CadastroRepository {

    private final Logger logger = LoggerFactory.getLogger(CadastroService.class);
    private final Map<String, ClienteResponse> CACHE = new HashMap<>();

    @Override
    @CircuitBreaker(name = "buscarClientePorIdCB", fallbackMethod = "buscarClientePorIdNoCache")
    public ClienteResponse buscarClientePorId(String id) {
        return executarRequisicao(id);
    }

    private ClienteResponse executarRequisicao(String id) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/clientes/" + id)
                .encode()
                .toUriString();

        logger.info("Buscando cliente por id");
        final ClienteResponse clienteResponse;
        try {
            clienteResponse = new RestTemplate()
                    .getForEntity(API_URL, ClienteResponse.class)
                    .getBody();
        } catch (Exception e) {
            logger.error("Erro ao buscar cliente por id");
            throw e;
        }

        logger.info("Populando cache");
        CACHE.put(id, clienteResponse);

        return clienteResponse;
    }

    private ClienteResponse buscarClientePorIdNoCache(String id) {
        return CACHE.getOrDefault(id, new ClienteResponse());
    }

}