package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;

public interface CadastroRepository {

    ClienteResponseDTO buscarClientePorId(String id);

}