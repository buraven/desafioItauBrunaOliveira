package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.domain.model.ClienteResponse;

public interface CadastroRepository {

    ClienteResponse buscarClientePorId(String id);

}