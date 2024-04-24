package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.CircuitBreakerLogConfig;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ContaService implements com.desafioitau.api.transferencia.domain.repository.ContaRepository {

    private final Logger logger = LoggerFactory.getLogger(ContaService.class);

    @Override
    @CircuitBreaker(name = "buscarContaPorIdCB", fallbackMethod = "buscarContaPorIdNoCache")
    public ContaResponseDTO buscarContaPorId(String id) {
        return executarRequisicao(id);
    }

    @Override
    @CircuitBreaker(name = "atualizarSaldoCB")
    public void atualizarSaldo(SaldoRequestDTO saldoRequestDTO) {
        executarRequisicao(saldoRequestDTO);
    }

    private ContaResponseDTO executarRequisicao(String id) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/contas/" + id)
                .encode()
                .toUriString();

        logger.info("Buscando conta por id");
        final ContaResponseDTO contaResponseDTO;
        try {
            contaResponseDTO = new RestTemplate()
                    .getForEntity(API_URL, ContaResponseDTO.class)
                    .getBody();
        } catch (Exception e) {
            logger.error("Erro ao buscar conta por id");
            throw e;
        }

        return contaResponseDTO;
    }

    private void executarRequisicao(SaldoRequestDTO saldoRequestDTO) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/contas/saldos")
                .encode()
                .toUriString();

        logger.info("Atualizar saldo apos tranferencia");
        try {
            new RestTemplate()
                    .put(API_URL, saldoRequestDTO);
        } catch (Exception e) {
            logger.error("Erro ao atualizar saldo apos tranferencia");
            throw e;
        }
    }

}