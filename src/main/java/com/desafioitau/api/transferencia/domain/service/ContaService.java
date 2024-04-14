package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;

public interface ContaService {

    ContaResponseDTO buscarContaPorId(String id);
    void atualizarSaldo(SaldoRequestDTO saldoRequestDTO);

}