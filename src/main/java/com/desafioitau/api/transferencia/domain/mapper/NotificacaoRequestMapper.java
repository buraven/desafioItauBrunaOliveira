package com.desafioitau.api.transferencia.domain.mapper;

import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotificacaoRequestMapper {

    public static NotificacaoRequestDTO dataMapper(TransferenciaRequestDTO transferenciaRequestDTO) {
        NotificacaoRequestDTO notificacaoRequestDTO = new NotificacaoRequestDTO();
        notificacaoRequestDTO.setValor(transferenciaRequestDTO.getValor());
        notificacaoRequestDTO.setConta(new NotificacaoRequestDTO.Conta());
        notificacaoRequestDTO.getConta().setIdOrigem(transferenciaRequestDTO.getConta().getIdOrigem());
        notificacaoRequestDTO.getConta().setIdDestino(transferenciaRequestDTO.getConta().getIdDestino());

        return notificacaoRequestDTO;
    }

}