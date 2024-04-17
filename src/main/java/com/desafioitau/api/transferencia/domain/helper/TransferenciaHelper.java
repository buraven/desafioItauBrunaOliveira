package com.desafioitau.api.transferencia.domain.helper;

import com.desafioitau.api.transferencia.domain.mapper.NotificacaoRequestMapper;
import com.desafioitau.api.transferencia.domain.mapper.SaldoRequestMapper;
import com.desafioitau.api.transferencia.dto.*;
import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.domain.service.ContaService;
import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
import com.desafioitau.api.transferencia.infra.utils.TransferenciaExceptionUtils;
import com.desafioitau.api.transferencia.infra.utils.constants.ErrorMessageConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class TransferenciaHelper {

    private final CadastroService cadastroService;
    private final ContaService contaService;
    private final NotificacaoService notificacaoService;

    public TransferenciaResponseDTO transferir(TransferenciaRequestDTO transferenciaRequestDTO) {
        TransferenciaResponseDTO transferenciaResponseDTO = new TransferenciaResponseDTO();

        String idOrigem = transferenciaRequestDTO.getConta().getIdOrigem();
        String idDestino = transferenciaRequestDTO.getConta().getIdDestino();

        if(clienteCadastrado(idDestino) && contaValidaParaTranferencia(idOrigem,
                                                transferenciaRequestDTO.getValor())) {
            contaService.atualizarSaldo(SaldoRequestMapper.dataMapper(transferenciaRequestDTO));
            notificacaoService.notificarBACEN(NotificacaoRequestMapper.dataMapper(transferenciaRequestDTO));
            transferenciaResponseDTO.setIdTransferencia(UUID.randomUUID());
        }

        return transferenciaResponseDTO;
    }

    private boolean clienteCadastrado(String id) {
        return cadastroService.buscarClientePorId(id) != null;
    }

    private boolean contaValidaParaTranferencia(String id, double valor) {
        ContaResponseDTO contaResponseDTO = contaService.buscarContaPorId(id);

        if (contaResponseDTO == null) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_CONTA_NAO_CADASTRADA);
        } else if (!contaResponseDTO.isAtivo()) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_CONTA_NAO_ATIVA);
        } else if (contaResponseDTO.getSaldo() <= 0) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_SALDO_MENOR_QUE_ZERO);
        } else if (contaResponseDTO.getSaldo() < valor) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_SALDO_INSUFICIENTE);
        } else if (contaResponseDTO.getLimiteDiario() <= 0) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_LIMITE_MENOR_QUE_ZERO);
        } else if (contaResponseDTO.getLimiteDiario() < valor) {
            TransferenciaExceptionUtils.exception(ErrorMessageConstants.ERRO_LIMITE_INSUFICIENTE);
        }

        return true;
    }

}