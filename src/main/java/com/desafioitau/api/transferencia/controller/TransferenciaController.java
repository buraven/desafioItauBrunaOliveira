package com.desafioitau.api.transferencia.controller;

import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaResponseDTO;
import com.desafioitau.api.transferencia.domain.helper.TransferenciaHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TransferenciaController {

    @Autowired
    private final TransferenciaHelper helper;

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponseDTO> efetuarTransferencia(
            @RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        return ResponseEntity.ok().body(helper.transferir(transferenciaRequestDTO));
    }
}
