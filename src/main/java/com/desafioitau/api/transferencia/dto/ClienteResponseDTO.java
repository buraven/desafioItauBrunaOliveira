package com.desafioitau.api.transferencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private String id;
    private String nome;
    private String telefone;
    private String tipoPessoa;
}
