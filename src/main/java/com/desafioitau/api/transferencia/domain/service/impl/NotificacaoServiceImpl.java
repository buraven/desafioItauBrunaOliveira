package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.CircuitBreakerLogConfig;
import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);
    private final RestTemplate restTemplate;

    public NotificacaoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @CircuitBreaker(name = "notificarBACENCB")
    public void notificarBACEN(NotificacaoRequestDTO notificacaoRequestDTO) {
        executarRequisicao(notificacaoRequestDTO);
    }

    private void executarRequisicao(NotificacaoRequestDTO notificacaoRequestDTO) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/notificacoes")
                .encode()
                .toUriString();

        logger.info("Notificando BACEN da tranferencia");
        try {
            restTemplate
                    .postForObject(API_URL, notificacaoRequestDTO, String.class);
        } catch (Exception e) {
            logger.error("Erro ao notificar BACEN");
            throw e;
        }
    }

}