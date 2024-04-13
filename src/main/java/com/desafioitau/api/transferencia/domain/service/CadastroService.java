package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;

public interface CadastroService {

    ClienteResponseDTO buscarClientePorId(String id);

}