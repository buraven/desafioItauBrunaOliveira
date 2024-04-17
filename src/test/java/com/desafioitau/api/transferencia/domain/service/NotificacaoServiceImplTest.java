package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.service.impl.NotificacaoServiceImpl;
import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificacaoServiceImplTest {

    @InjectMocks
    private NotificacaoServiceImpl notificacaoServiceImpl;

    private NotificacaoRequestDTO notificacaoRequest;

    @BeforeEach
    public void setUp() {
        startNotificacaoRequest();
    }

    @Test
    public void deveNotificarBACEN() {
        notificacaoServiceImpl.notificarBACEN(notificacaoRequest);
    }

    private void startNotificacaoRequest() {
        NotificacaoRequestDTO notificacaoRequestDTO = new NotificacaoRequestDTO();
        notificacaoRequestDTO.setValor(1000.00);
        notificacaoRequestDTO.setConta(new NotificacaoRequestDTO.Conta());
        notificacaoRequestDTO.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        notificacaoRequestDTO.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        notificacaoRequest = notificacaoRequestDTO;
    }

}