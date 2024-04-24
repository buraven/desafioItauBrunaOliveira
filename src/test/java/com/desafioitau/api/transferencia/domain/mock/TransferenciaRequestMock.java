package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.domain.model.TransferenciaRequest;

public class TransferenciaRequestMock {

    public static TransferenciaRequest getTransferenciaRequest_Ok() {
        TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
        transferenciaRequest.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequest.setValor(500.00);
        transferenciaRequest.setConta(new TransferenciaRequest.Conta());
        transferenciaRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return transferenciaRequest;
    }

    public static TransferenciaRequest getTransferenciaRequest_ClienteDestinoNaoCadastrado() {
        TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
        transferenciaRequest.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequest.setValor(500.00);
        transferenciaRequest.setConta(new TransferenciaRequest.Conta());
        transferenciaRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffa5454a76f");

        return transferenciaRequest;
    }

    public static TransferenciaRequest getTransferenciaRequest_ContaOrigemNaoCadastrada() {
        TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
        transferenciaRequest.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequest.setValor(500.00);
        transferenciaRequest.setConta(new TransferenciaRequest.Conta());
        transferenciaRequest.getConta().setIdOrigem("d0d65842-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return transferenciaRequest;
    }

    public static TransferenciaRequest getTransferenciaRequest_SaldoInsuficiente() {
        TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
        transferenciaRequest.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequest.setValor(50000.00);
        transferenciaRequest.setConta(new TransferenciaRequest.Conta());
        transferenciaRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return transferenciaRequest;
    }

    public static TransferenciaRequest getTransferenciaRequest_LimiteDiarioInsuficiente() {
        TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
        transferenciaRequest.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequest.setValor(5000.00);
        transferenciaRequest.setConta(new TransferenciaRequest.Conta());
        transferenciaRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return transferenciaRequest;
    }

}