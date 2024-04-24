package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.CircuitBreakerLogConfig;
import com.desafioitau.api.transferencia.domain.repository.NotificacaoRepository;
import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NotificacaoService implements NotificacaoRepository {

    private final Logger logger = LoggerFactory.getLogger(NotificacaoService.class);

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
            new RestTemplate()
                    .postForObject(API_URL, notificacaoRequestDTO, String.class);
        } catch (Exception e) {
            logger.error("Erro ao notificar BACEN");
            throw e;
        }
    }

}