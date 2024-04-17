package com.desafioitau.api.transferencia.domain.helper;

import com.desafioitau.api.transferencia.domain.mock.ClienteResponseDTOMock;
import com.desafioitau.api.transferencia.domain.mock.ContaResponseDTOMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaRequestDTOMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaResponseDTOMock;
import com.desafioitau.api.transferencia.domain.service.CadastroService;
import com.desafioitau.api.transferencia.domain.service.ContaService;
import com.desafioitau.api.transferencia.domain.service.NotificacaoService;
import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferenciaHelperTest {

    @InjectMocks
    private TransferenciaHelper helper;

    @Mock
    private CadastroService cadastroService;

    @Mock
    private ContaService contaService;

    @Mock
    private NotificacaoService notificacaoService;

    private ClienteResponseDTO clienteDestino;
    private ContaResponseDTO contaOrigem;
    private TransferenciaResponseDTO transferenciaResponseDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteDestino = ClienteResponseDTOMock.getClienteResponseDTO_Ok();
        contaOrigem = ContaResponseDTOMock.getContaResponseDTO_Ok();
        transferenciaResponseDTO = TransferenciaResponseDTOMock.getTransferenciaResponseDTO_Ok();
    }

    @Test
    public void deveTransferir() {
        when(cadastroService.buscarClientePorId(any())).thenReturn(clienteDestino);
        when(contaService.buscarContaPorId(any())).thenReturn(contaOrigem);

        TransferenciaResponseDTO response = helper.transferir(TransferenciaRequestDTOMock.getTransferenciaRequestDTO_Ok());

        assertNotNull(response);
        assertEquals(transferenciaResponseDTO.getClass(), response.getClass());
    }

}