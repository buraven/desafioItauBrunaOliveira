package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.domain.model.ContaResponse;

public class ContaResponseMock {

    public static ContaResponse getContaResponse_Ok() {
        return new ContaResponse("d0d32142-74b7-4aca-9c68-838aeacef96b", 5000.00, 500.00, true);
    }

}