package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.ContaService;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContaServiceImpl implements ContaService {

    @Override
    public ContaResponseDTO buscarContaPorId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ContaResponseDTO> response = restTemplate
                .getForEntity("http://localhost:9090/contas/" + id, ContaResponseDTO.class);

        return response.getBody();
    }

}