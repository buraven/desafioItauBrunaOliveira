package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.model.ContaResponse;
import com.desafioitau.api.transferencia.domain.model.SaldoRequest;
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
    public ContaResponse buscarContaPorId(String id) {
        return executarRequisicao(id);
    }

    @Override
    @CircuitBreaker(name = "atualizarSaldoCB")
    public void atualizarSaldo(SaldoRequest saldoRequest) {
        executarRequisicao(saldoRequest);
    }

    private ContaResponse executarRequisicao(String id) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/contas/" + id)
                .encode()
                .toUriString();

        logger.info("Buscando conta por id");
        final ContaResponse contaResponse;
        try {
            contaResponse = new RestTemplate()
                    .getForEntity(API_URL, ContaResponse.class)
                    .getBody();
        } catch (Exception e) {
            logger.error("Erro ao buscar conta por id");
            throw e;
        }

        return contaResponse;
    }

    private void executarRequisicao(SaldoRequest saldoRequest) {
        final String API_URL = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9090/contas/saldos")
                .encode()
                .toUriString();

        logger.info("Atualizar saldo apos tranferencia");
        try {
            new RestTemplate()
                    .put(API_URL, saldoRequest);
        } catch (Exception e) {
            logger.error("Erro ao atualizar saldo apos tranferencia");
            throw e;
        }
    }

}