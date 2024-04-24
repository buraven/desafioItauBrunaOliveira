package com.desafioitau.api.transferencia.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoRequest {

    private double valor;
    private Conta conta;

    @Getter @Setter
    public static class Conta {
        private String idOrigem;
        private String idDestino;
    }

}