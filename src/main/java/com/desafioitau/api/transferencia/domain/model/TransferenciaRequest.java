package com.desafioitau.api.transferencia.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaRequest {

    @NotNull
    private String idCliente;

    @NotNull
    private double valor;

    @NotNull
    private Conta conta;

    @Getter @Setter
    @NotNull
    public static class Conta {
        @NotNull
        private String idOrigem;

        @NotNull
        private String idDestino;
    }

}