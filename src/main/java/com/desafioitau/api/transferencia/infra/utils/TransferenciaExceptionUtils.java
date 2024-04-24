package com.desafioitau.api.transferencia.infra.utils;

import com.desafioitau.api.transferencia.domain.helper.TransferenciaHelper;
import com.desafioitau.api.transferencia.infra.exception.TransferenciaException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
public class TransferenciaExceptionUtils {

    private static final Logger logger = LoggerFactory.getLogger(TransferenciaHelper.class);

    public static void exception(String mensagem) {
        logger.error(mensagem);
        throw new TransferenciaException(mensagem);
    }

}