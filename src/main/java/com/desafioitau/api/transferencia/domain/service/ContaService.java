package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;

public interface ContaService {

    ContaResponseDTO buscarContaPorId(String id);

}