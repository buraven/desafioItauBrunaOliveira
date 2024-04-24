package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.mock.ContaResponseMock;
import com.desafioitau.api.transferencia.domain.mock.SaldoRequestMock;
import com.desafioitau.api.transferencia.domain.model.ContaResponse;
import com.desafioitau.api.transferencia.domain.model.SaldoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;

    private ContaResponse conta;
    private SaldoRequest saldoRequest;

    @BeforeEach
    public void setUp() {
       conta = ContaResponseMock.getContaResponse_Ok();
       saldoRequest = SaldoRequestMock.getSaldoRequest_Ok();
    }

    @Test
    public void deveBuscarContaPorId() {
        ContaResponse response = service.buscarContaPorId("d0d32142-74b7-4aca-9c68-838aeacef96b");

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