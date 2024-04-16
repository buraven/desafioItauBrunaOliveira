package com.desafioitau.api.transferencia.infra.utils;

import com.desafioitau.api.transferencia.infra.exception.TransferenciaException;

public class TransferenciaExceptionUtils {

    private TransferenciaExceptionUtils() {}

    public static void exception(String mensagem) {
        throw new TransferenciaException(mensagem);
    }

}