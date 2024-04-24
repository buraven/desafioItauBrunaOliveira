package com.desafioitau.api.transferencia.domain.core;

import com.desafioitau.api.transferencia.domain.mapper.NotificacaoRequestMapper;
import com.desafioitau.api.transferencia.domain.mapper.SaldoRequestMapper;
import com.desafioitau.api.transferencia.domain.model.ContaResponse;
import com.desafioitau.api.transferencia.domain.model.TransferenciaRequest;
import com.desafioitau.api.transferencia.domain.model.TransferenciaResponse;
import com.desafioitau.api.transferencia.domain.repository.CadastroRepository;
import com.desafioitau.api.transferencia.domain.repository.ContaRepository;
import com.desafioitau.api.transferencia.domain.repository.NotificacaoRepository;
import com.desafioitau.api.transferencia.domain.utils.TransferenciaExceptionUtils;
import com.desafioitau.api.transferencia.domain.utils.constants.ErrorMessageConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class TransferenciaCore {

    private final CadastroRepository cadastroRepository;
    private final ContaRepository contaRepository;
    private final NotificacaoRepository notificacaoRepository;

    public TransferenciaResponse transferir(TransferenciaRequest transferenciaRequest) {
        TransferenciaResponse transferenciaResponse = new TransferenciaResponse();

        String idOrigem = transferenciaRequest.getConta().getIdOrigem();
        String idDestino = transferenciaRequest.getConta().getIdDestino();

        if(clienteCadastrado(idDestino) && contaValidaParaTranferencia(idOrigem,
                                                transferenciaRequest.getValor())) {
            contaRepository.atualizarSaldo(SaldoRequestMapper.dataMapper(transferenciaRequest));
            notificacaoRepository.notificarBACEN(NotificacaoRequestMapper.dataMapper(transferenciaRequest));
            transferenciaResponse.setIdTransferencia(UUID.randomUUID());
        }

        return transferenciaResponse;
    }

    private boolean clienteCadastrado(String id) {
        return cadastroRepository.buscarClientePorId(id) != null;
    }

    private boolean contaValidaParaTranferencia(String id, double valor) {
        ContaResponse contaResponse = contaRepository.buscarContaPorId(id);

        if (contaResponse == null) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_CONTA_NAO_CADASTRADA);
        } else if (!contaResponse.isAtivo()) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_CONTA_NAO_ATIVA);
        } else if (contaResponse.getSaldo() <= 0) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_SALDO_MENOR_QUE_ZERO);
        } else if (contaResponse.getSaldo() < valor) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_SALDO_INSUFICIENTE);
        } else if (contaResponse.getLimiteDiario() <= 0) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_LIMITE_MENOR_QUE_ZERO);
        } else if (contaResponse.getLimiteDiario() < valor) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_LIMITE_INSUFICIENTE);
        }

        return true;
    }

}