package com.desafioitau.api.transferencia.domain.mock;

import com.desafioitau.api.transferencia.domain.model.ClienteResponse;

public class ClienteResponseMock {

    public static ClienteResponse getClienteResponse_Ok() {
        return new ClienteResponse("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f", "Artur Carneiro",
                "987651234", "Fisica");
    }

}