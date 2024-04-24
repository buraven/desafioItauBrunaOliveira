package com.desafioitau.api.transferencia.adapters;

import com.desafioitau.api.transferencia.domain.model.TransferenciaRequest;
import com.desafioitau.api.transferencia.domain.model.TransferenciaResponse;
import com.desafioitau.api.transferencia.domain.core.TransferenciaCore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TransferenciaAdapter {

    @Autowired
    private final TransferenciaCore core;

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponse> efetuarTransferencia(
            @RequestBody TransferenciaRequest transferenciaRequest) {
        return ResponseEntity.ok().body(core.transferir(transferenciaRequest));
    }
}
