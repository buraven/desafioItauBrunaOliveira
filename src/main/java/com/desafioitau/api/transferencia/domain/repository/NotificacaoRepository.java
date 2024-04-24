package com.desafioitau.api.transferencia.domain.repository;

import com.desafioitau.api.transferencia.domain.model.NotificacaoRequest;

public interface NotificacaoRepository {

    void notificarBACEN(NotificacaoRequest notificacaoRequest);

}