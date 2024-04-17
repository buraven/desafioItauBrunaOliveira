package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;

public class ClienteResponseDTOMock {

    public static ClienteResponseDTO getClienteResponseDTO_Ok() {
        return new ClienteResponseDTO("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f", "Artur Carneiro",
                "987651234", "Fisica");
    }

}