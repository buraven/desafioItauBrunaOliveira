package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.domain.model.SaldoRequest;

public class SaldoRequestMock {

    public static SaldoRequest getSaldoRequest_Ok() {
        SaldoRequest saldoRequest = new SaldoRequest();
        saldoRequest.setValor(1000.00);
        saldoRequest.setConta(new SaldoRequest.Conta());
        saldoRequest.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        saldoRequest.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return saldoRequest;
    }

}