package com.desafioitau.api.transferencia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ClienteResponseDTO {

    private String id;
    private String nome;
    private String telefone;
    private String tipoPessoa;
}
