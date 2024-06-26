package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.model.NotificacaoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificacaoServiceTest {

    @InjectMocks
    private NotificacaoService notificacaoServiceImpl;

    private NotificacaoRequest notificacaoRequest;

    @BeforeEach
    public void setUp() {
        startNotificacaoRequest();
    }

    @Test
    public void deveNotificarBACEN() {
        notificacaoServiceImpl.notificarBACEN(notificacaoRequest);
    }

    private void startNotificacaoRequest() {
        NotificacaoRequest notificacaoRequest = new NotificacaoRequest();
        notificacaoRequest.setValor(1000.00);
        notificacaoRequest.setConta(new NotificacaoRequest.Conta());
        notificacaoRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        notificacaoRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        this.notificacaoRequest = notificacaoRequest;
    }

}