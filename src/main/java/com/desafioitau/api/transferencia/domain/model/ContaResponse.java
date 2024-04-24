package com.desafioitau.api.transferencia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponse {

    private String id;
    private double saldo;
    private double limiteDiario;
    private boolean ativo;

}