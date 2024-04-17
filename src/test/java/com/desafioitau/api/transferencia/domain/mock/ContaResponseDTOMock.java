package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;

public class ContaResponseDTOMock {

    public static ContaResponseDTO getContaResponseDTO_Ok() {
        return new ContaResponseDTO("d0d32142-74b7-4aca-9c68-838aeacef96b", 5000.00, 500.00, true);
    }

}