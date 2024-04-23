package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;

public interface ContaRepository {

    ContaResponseDTO buscarContaPorId(String id);
    void atualizarSaldo(SaldoRequestDTO saldoRequestDTO);

}