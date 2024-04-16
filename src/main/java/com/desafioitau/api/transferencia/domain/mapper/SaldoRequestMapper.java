package com.desafioitau.api.transferencia.domain.mapper;

import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;

public class SaldoRequestMapper {

    private SaldoRequestMapper() {

    }

    public static SaldoRequestDTO dataMapper(TransferenciaRequestDTO transferenciaRequestDTO) {
        SaldoRequestDTO saldoRequestDTO = new SaldoRequestDTO();
        saldoRequestDTO.setValor(transferenciaRequestDTO.getValor());
        saldoRequestDTO.setConta(new SaldoRequestDTO.Conta());
        saldoRequestDTO.getConta().setIdOrigem(transferenciaRequestDTO.getConta().getIdOrigem());
        saldoRequestDTO.getConta().setIdDestino(transferenciaRequestDTO.getConta().getIdDestino());

        return saldoRequestDTO;
    }

}