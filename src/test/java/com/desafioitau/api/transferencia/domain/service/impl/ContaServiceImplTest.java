package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContaServiceImplTest {

    @InjectMocks
    private ContaServiceImpl service;

    private ContaResponseDTO conta;
    private SaldoRequestDTO saldoRequest;

    @BeforeEach
    void setUp() {
        startConta();
        startSaldoRequest();
    }

    @Test
    void deveBuscarContaPorId() {
        ContaResponseDTO response = service.buscarContaPorId("d0d32142-74b7-4aca-9c68-838aeacef96b");

        assertNotNull(response);
        assertEquals(conta.getClass(), response.getClass());
        assertEquals(conta.getId(), response.getId());
        assertEquals(conta.getSaldo(), response.getSaldo());
        assertEquals(conta.getLimiteDiario(), response.getLimiteDiario());
        assertEquals(conta.isAtivo(), response.isAtivo());
    }

    @Test
    void deveAtualizarSaldo() {
        service.atualizarSaldo(saldoRequest);
    }

    private void startConta() {
        conta = new ContaResponseDTO("d0d32142-74b7-4aca-9c68-838aeacef96b", 5000.00, 500.00, true);
    }

    private void startSaldoRequest() {
        SaldoRequestDTO saldoRequestDTO = new SaldoRequestDTO();
        saldoRequestDTO.setValor(1000.00);
        saldoRequestDTO.setConta(new SaldoRequestDTO.Conta());
        saldoRequestDTO.getConta().setIdOrigem("d0d32142-74b7-4aca-9c68-838aeacef96b");
        saldoRequestDTO.getConta().setIdDestino("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        saldoRequest = saldoRequestDTO;
    }

}