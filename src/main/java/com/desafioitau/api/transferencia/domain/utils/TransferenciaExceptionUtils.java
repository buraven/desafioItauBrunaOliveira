package com.desafioitau.api.transferencia.domain.utils;

import com.desafioitau.api.transferencia.domain.core.TransferenciaCore;
import com.desafioitau.api.transferencia.domain.exception.TransferenciaException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class TransferenciaExceptionUtils {

    private static final Logger logger = LoggerFactory.getLogger(TransferenciaCore.class);

    public static void exception(String mensagem) {
        logger.error(mensagem);
        throw new TransferenciaException(mensagem);
    }

}