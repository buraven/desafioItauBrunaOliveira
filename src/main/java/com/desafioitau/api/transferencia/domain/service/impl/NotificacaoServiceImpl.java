package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Override
    @CircuitBreaker(name = "notificarBACENCB")
    public void notificarBACEN(NotificacaoRequestDTO notificacaoRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate
                .postForObject("http://localhost:9090/notificacoes", notificacaoRequestDTO, String.class);
    }

}