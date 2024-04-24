package com.desafioitau.api.transferencia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private String id;
    private String nome;
    private String telefone;
    private String tipoPessoa;

}