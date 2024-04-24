package com.desafioitau.api.transferencia.domain.mapper;

import com.desafioitau.api.transferencia.domain.model.NotificacaoRequest;
import com.desafioitau.api.transferencia.domain.model.TransferenciaRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotificacaoRequestMapper {

    public static NotificacaoRequest dataMapper(TransferenciaRequest transferenciaRequest) {
        NotificacaoRequest notificacaoRequest = new NotificacaoRequest();
        notificacaoRequest.setValor(transferenciaRequest.getValor());
        notificacaoRequest.setConta(new NotificacaoRequest.Conta());
        notificacaoRequest.getConta().setIdOrigem(transferenciaRequest.getConta().getIdOrigem());
        notificacaoRequest.getConta().setIdDestino(transferenciaRequest.getConta().getIdDestino());

        return notificacaoRequest;
    }

}