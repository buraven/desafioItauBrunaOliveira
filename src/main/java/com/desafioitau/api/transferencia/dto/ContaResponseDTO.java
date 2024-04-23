package com.desafioitau.api.transferencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDTO {

    private String id;
    private double saldo;
    private double limiteDiario;
    private boolean ativo;
}
