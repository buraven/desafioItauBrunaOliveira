package com.desafioitau.api.transferencia.domain.service.impl;

import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContaServiceImplTest {

    @InjectMocks
    private ContaServiceImpl service;

    private ContaResponseDTO conta;

    @BeforeEach
    void setUp() {
        startConta();
    }

    @Test
    void buscarContaPorId() {
        ContaResponseDTO response = service.buscarContaPorId("d0d32142-74b7-4aca-9c68-838aeacef96b");

        assertNotNull(response);
        assertEquals(conta.getClass(), response.getClass());
        assertEquals(conta.getId(), response.getId());
        assertEquals(conta.getSaldo(), response.getSaldo());
        assertEquals(conta.getLimiteDiario(), response.getLimiteDiario());
        assertEquals(conta.isAtivo(), response.isAtivo());
    }

    private void startConta() {
        conta = new ContaResponseDTO("d0d32142-74b7-4aca-9c68-838aeacef96b", 5000.00, 500.00, true);
    }

}