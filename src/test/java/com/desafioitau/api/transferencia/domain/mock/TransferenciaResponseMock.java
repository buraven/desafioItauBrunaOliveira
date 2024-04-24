package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.domain.model.TransferenciaResponse;

import java.util.UUID;

public class TransferenciaResponseMock {

    public static TransferenciaResponse getTransferenciaResponse_Ok() {
        TransferenciaResponse response = new TransferenciaResponse();
        response.setIdTransferencia(UUID.randomUUID());

        return response;
    }

}