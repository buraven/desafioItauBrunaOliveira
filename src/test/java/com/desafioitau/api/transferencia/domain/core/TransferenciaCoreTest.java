package com.desafioitau.api.transferencia.domain.core;

import com.desafioitau.api.transferencia.domain.mock.ClienteResponseMock;
import com.desafioitau.api.transferencia.domain.mock.ContaResponseMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaRequestMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaResponseMock;
import com.desafioitau.api.transferencia.domain.repository.CadastroRepository;
import com.desafioitau.api.transferencia.domain.repository.ContaRepository;
import com.desafioitau.api.transferencia.domain.repository.NotificacaoRepository;
import com.desafioitau.api.transferencia.domain.model.ClienteResponse;
import com.desafioitau.api.transferencia.domain.model.ContaResponse;
import com.desafioitau.api.transferencia.domain.model.TransferenciaResponse;
import com.desafioitau.api.transferencia.domain.exception.TransferenciaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferenciaCoreTest {

    @Autowired
    private TransferenciaCore helper;

    @Mock
    private CadastroRepository cadastroRepository;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private NotificacaoRepository notificacaoRepository;

    private ClienteResponse clienteDestino;
    private ContaResponse contaOrigem;
    private TransferenciaResponse transferenciaResponse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteDestino = ClienteResponseMock.getClienteResponse_Ok();
        contaOrigem = ContaResponseMock.getContaResponse_Ok();
        transferenciaResponse = TransferenciaResponseMock.getTransferenciaResponse_Ok();
    }

    @Test
    public void deveTransferir() {
        when(cadastroRepository.buscarClientePorId(any())).thenReturn(clienteDestino);
        when(contaRepository.buscarContaPorId(any())).thenReturn(contaOrigem);

        TransferenciaResponse response = helper.transferir(TransferenciaRequestMock.getTransferenciaRequest_Ok());

        assertNotNull(response);
        assertEquals(transferenciaResponse.getClass(), response.getClass());
    }

    @Test
    public void naoDeveTransferir_ClienteDestinoNaoCadastrado() {
        assertThrows(HttpClientErrorException.class,
                () -> helper.transferir(TransferenciaRequestMock
                        .getTransferenciaRequest_ClienteDestinoNaoCadastrado()));
    }

    @Test
    public void naoDeveTransferir_ContaOrigemNaoCadastrada() {
        assertThrows(HttpClientErrorException.class,
                () -> helper.transferir(TransferenciaRequestMock
                        .getTransferenciaRequest_ContaOrigemNaoCadastrada()));
    }

    @Test
    public void naoDeveTransferir_SaldoInsuficiente() {
        assertThrows(TransferenciaException.class,
                () -> helper.transferir(TransferenciaRequestMock
                        .getTransferenciaRequest_SaldoInsuficiente()));
    }

    @Test
    public void naoDeveTransferir_LimiteDiarioInsuficiente() {
        assertThrows(TransferenciaException.class,
                () -> helper.transferir(TransferenciaRequestMock
                        .getTransferenciaRequest_LimiteDiarioInsuficiente()));
    }

    //TODO - fazer testes restantes para incluir outros cenários do if quando a api retornar todos os cenarios

}