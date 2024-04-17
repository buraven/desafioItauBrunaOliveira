package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;

public class SaldoRequestDTOMock {

    public static SaldoRequestDTO getSaldoRequestDTO_Ok() {
        SaldoRequestDTO saldoRequestDTO = new SaldoRequestDTO();
        saldoRequestDTO.setValor(1000.00);
        saldoRequestDTO.setConta(new SaldoRequestDTO.Conta());
        saldoRequestDTO.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        saldoRequestDTO.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        return saldoRequestDTO;
    }

}