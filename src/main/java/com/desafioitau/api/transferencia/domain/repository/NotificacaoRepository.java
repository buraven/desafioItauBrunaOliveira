package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;

public interface NotificacaoRepository {

    void notificarBACEN(NotificacaoRequestDTO notificacaoRequestDTO);

}