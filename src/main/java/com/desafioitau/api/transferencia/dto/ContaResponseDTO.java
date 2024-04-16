package com.desafioitau.api.transferencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ContaResponseDTO {

    private String id;
    private double saldo;
    private double limiteDiario;
    private boolean ativo;
}
