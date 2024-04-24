package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.domain.model.ContaResponse;
import com.desafioitau.api.transferencia.domain.model.SaldoRequest;

public interface ContaRepository {

    ContaResponse buscarContaPorId(String id);
    void atualizarSaldo(SaldoRequest saldoRequest);

}