package com.desafioitau.api.transferencia.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaRequestDTO {

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