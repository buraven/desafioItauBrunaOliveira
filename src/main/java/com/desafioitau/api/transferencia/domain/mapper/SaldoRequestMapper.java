package com.desafioitau.api.transferencia.domain.mapper;

import com.desafioitau.api.transferencia.domain.model.SaldoRequest;
import com.desafioitau.api.transferencia.domain.model.TransferenciaRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SaldoRequestMapper {

    public static SaldoRequest dataMapper(TransferenciaRequest transferenciaRequest) {
        SaldoRequest saldoRequest = new SaldoRequest();
        saldoRequest.setValor(transferenciaRequest.getValor());
        saldoRequest.setConta(new SaldoRequest.Conta());
        saldoRequest.getConta().setIdOrigem(transferenciaRequest.getConta().getIdOrigem());
        saldoRequest.getConta().setIdDestino(transferenciaRequest.getConta().getIdDestino());

        return saldoRequest;
    }

}