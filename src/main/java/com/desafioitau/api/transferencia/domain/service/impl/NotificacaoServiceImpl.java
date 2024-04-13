package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Override
    public void notificarBACEN(NotificacaoRequestDTO notificacaoRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate
                .put("http://localhost:9090/contas/saldos", notificacaoRequestDTO);
    }

}