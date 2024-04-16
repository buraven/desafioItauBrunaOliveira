package com.desafioitau.api.transferencia.domain.service;

import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroServiceImplTest {

    @InjectMocks
    private CadastroServiceImpl service;

    private ClienteResponseDTO cliente;

    @BeforeEach
    public void setUp() {
        startCliente();
    }

    @Test
    public void deveBuscarClientePorId() {
        ClienteResponseDTO response = service.buscarClientePorId("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f");

        assertNotNull(response);
        assertEquals(cliente.getClass(), response.getClass());
        assertEquals(cliente.getId(), response.getId());
        assertEquals(cliente.getNome(), response.getNome());
        assertEquals(cliente.getTelefone(), response.getTelefone());
        assertEquals(cliente.getTipoPessoa(), response.getTipoPessoa());
    }

    private void startCliente() {
        cliente = new ClienteResponseDTO("2ceb26e9-7b5c-417e-bf75-ffaa66e3a76f", "Artur Carneiro",
                "987651234", "Fisica");
    }

}