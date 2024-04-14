package com.desafioitau.api.transferencia.domain.helper;

import com.desafioitau.api.transferencia.domain.exception.TransferenciaException;
import com.desafioitau.api.transferencia.dto.*;
import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.domain.service.ContaService;
import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
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

        if(clienteCadastrado(idDestino)
            && contaValidaParaTranferencia(idOrigem, transferenciaRequestDTO.getValor())) {
            atualizarSaldo(transferenciaRequestDTO);
            notificarBACEN(transferenciaRequestDTO);
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
            exception("Conta não cadastrata");
        } else if (!contaResponseDTO.isAtivo()) {
            exception("Conta não está ativa");
        } else if (contaResponseDTO.getSaldo() <= 0) {
            exception("Saldo não pode ser menor ou igual a zero");
        } else if (contaResponseDTO.getSaldo() < valor) {
            exception("Saldo insuficiente");
        } else if (contaResponseDTO.getLimiteDiario() <= 0) {
            exception("Limite diário não pode ser menor ou igual a zero");
        } else if (contaResponseDTO.getLimiteDiario() < valor) {
            exception("Limite insuficiente");
        } else {
            return true;
        }

        return false;
    }

    //COLOCAR MAPPER
    private void atualizarSaldo(TransferenciaRequestDTO transferenciaRequestDTO) {
        SaldoRequestDTO saldoRequestDTO = new SaldoRequestDTO();
        saldoRequestDTO.setValor(transferenciaRequestDTO.getValor());
        saldoRequestDTO.setConta(new SaldoRequestDTO.Conta());
        saldoRequestDTO.getConta().setIdOrigem(transferenciaRequestDTO.getConta().getIdOrigem());
        saldoRequestDTO.getConta().setIdDestino(transferenciaRequestDTO.getConta().getIdDestino());

        contaService.atualizarSaldo(saldoRequestDTO);
    }

    private void notificarBACEN(TransferenciaRequestDTO transferenciaRequestDTO) {
        NotificacaoRequestDTO notificacaoRequestDTO = new NotificacaoRequestDTO();
        notificacaoRequestDTO.setValor(transferenciaRequestDTO.getValor());
        notificacaoRequestDTO.setConta(new NotificacaoRequestDTO.Conta());
        notificacaoRequestDTO.getConta().setIdOrigem(transferenciaRequestDTO.getConta().getIdOrigem());
        notificacaoRequestDTO.getConta().setIdDestino(transferenciaRequestDTO.getConta().getIdDestino());

        notificacaoService.notificarBACEN(notificacaoRequestDTO);
    }

    private void exception(String mensagem) {
        throw new TransferenciaException(mensagem);
    }

}