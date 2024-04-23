package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.mock.ContaResponseDTOMock;
import com.desafioitau.api.transferencia.domain.mock.SaldoRequestDTOMock;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.SaldoRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;

    private ContaResponseDTO conta;
    private SaldoRequestDTO saldoRequest;

    @BeforeEach
    public void setUp() {
       conta = ContaResponseDTOMock.getContaResponseDTO_Ok();
       saldoRequest = SaldoRequestDTOMock.getSaldoRequestDTO_Ok();
    }

    @Test
    public void deveBuscarContaPorId() {
        ContaResponseDTO response = service.buscarContaPorId("d0d32142-74b7-4aca-9c68-838aeacef96b");

        assertNotNull(response);
        assertEquals(conta.getClass(), response.getClass());
        assertEquals(conta.getId(), response.getId());
        assertEquals(conta.getSaldo(), response.getSaldo());
        assertEquals(conta.getLimiteDiario(), response.getLimiteDiario());
        assertEquals(conta.isAtivo(), response.isAtivo());
    }

    @Test
    public void deveAtualizarSaldo() {
        service.atualizarSaldo(saldoRequest);
    }

}