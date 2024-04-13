package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CadastroServiceImpl implements CadastroService {

    @Override
    public ClienteResponseDTO buscarClientePorId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ClienteResponseDTO> response = restTemplate
                .getForEntity("http://localhost:9090/clientes/" + id, ClienteResponseDTO.class);

        return response.getBody();
    }

}