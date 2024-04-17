package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.dto.TransferenciaResponseDTO;

import java.util.UUID;

public class TransferenciaResponseDTOMock {

    public static TransferenciaResponseDTO getTransferenciaResponseDTO_Ok() {
        TransferenciaResponseDTO response = new TransferenciaResponseDTO();
        response.setIdTransferencia(UUID.randomUUID());

        return response;
    }

}