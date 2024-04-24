package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.domain.mock.ClienteResponseMock;
import com.desafioitau.api.transferencia.domain.model.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroServiceTest {

    @InjectMocks
    private CadastroService service;

    private ClienteResponse cliente;

    @BeforeEach
    public void setUp() {
        cliente = ClienteResponseMock.getClienteResponse_Ok();
    }

    @Test
    public void deveBuscarClientePorId() {
        ClienteResponse response = service.buscarClientePorId("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        assertNotNull(response);
        assertEquals(cliente.getClass(), response.getClass());
        assertEquals(cliente.getId(), response.getId());
        assertEquals(cliente.getNome(), response.getNome());
        assertEquals(cliente.getTelefone(), response.getTelefone());
        assertEquals(cliente.getTipoPessoa(), response.getTipoPessoa());
    }

}