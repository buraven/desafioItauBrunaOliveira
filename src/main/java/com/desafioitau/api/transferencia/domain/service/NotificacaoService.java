package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.dto.NotificacaoRequestDTO;

public interface NotificacaoService {

    void notificarBACEN(NotificacaoRequestDTO notificacaoRequestDTO);

}