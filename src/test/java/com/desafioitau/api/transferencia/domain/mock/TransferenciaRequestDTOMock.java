package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;

public class TransferenciaRequestDTOMock {

    public static TransferenciaRequestDTO getTransferenciaRequestDTO_Ok() {
        TransferenciaRequestDTO transferenciaRequestDTO = new TransferenciaRequestDTO();
        transferenciaRequestDTO.setIdCliente("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");
        transferenciaRequestDTO.setValor(500.00);
        transferenciaRequestDTO.setConta(new TransferenciaRequestDTO.Conta());
        transferenciaRequestDTO.getConta().setIdDestino("d0d32142-74b7-4aca-9c68-838aeacef96b");
        transferenciaRequestDTO.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return transferenciaRequestDTO;
    }

}