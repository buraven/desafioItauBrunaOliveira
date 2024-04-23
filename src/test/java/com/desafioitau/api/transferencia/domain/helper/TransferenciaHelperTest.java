package com.desafioitau.api.transferencia.domain.helper;

import com.desafioitau.api.transferencia.domain.mock.ClienteResponseDTOMock;
import com.desafioitau.api.transferencia.domain.mock.ContaResponseDTOMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaRequestDTOMock;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaResponseDTOMock;
import com.desafioitau.api.transferencia.domain.repository.CadastroRepository;
import com.desafioitau.api.transferencia.domain.repository.ContaRepository;
import com.desafioitau.api.transferencia.domain.repository.NotificacaoRepository;
import com.desafioitau.api.transferencia.dto.ClienteResponseDTO;
import com.desafioitau.api.transferencia.dto.ContaResponseDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaResponseDTO;
import com.desafioitau.api.transferencia.infra.exception.TransferenciaException;
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
public class TransferenciaHelperTest {

    @Autowired
    private TransferenciaHelper helper;

    @Mock
    private CadastroRepository cadastroRepository;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private NotificacaoRepository notificacaoRepository;

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
        when(cadastroRepository.buscarClientePorId(any())).thenReturn(clienteDestino);
        when(contaRepository.buscarContaPorId(any())).thenReturn(contaOrigem);

        TransferenciaResponseDTO response = helper.transferir(TransferenciaRequestDTOMock.getTransferenciaRequestDTO_Ok());

        assertNotNull(response);
        assertEquals(transferenciaResponseDTO.getClass(), response.getClass());
    }

    @Test
    public void naoDeveTransferir_ClienteDestinoNaoCadastrado() {
        assertThrows(HttpClientErrorException.class,
                () -> helper.transferir(TransferenciaRequestDTOMock
                        .getTransferenciaRequestDTO_ClienteDestinoNaoCadastrado()));
    }

    @Test
    public void naoDeveTransferir_ContaOrigemNaoCadastrada() {
        assertThrows(HttpClientErrorException.class,
                () -> helper.transferir(TransferenciaRequestDTOMock
                        .getTransferenciaRequestDTO_ContaOrigemNaoCadastrada()));
    }

    @Test
    public void naoDeveTransferir_SaldoInsuficiente() {
        assertThrows(TransferenciaException.class,
                () -> helper.transferir(TransferenciaRequestDTOMock
                        .getTransferenciaRequestDTO_SaldoInsuficiente()));
    }

    @Test
    public void naoDeveTransferir_LimiteDiarioInsuficiente() {
        assertThrows(TransferenciaException.class,
                () -> helper.transferir(TransferenciaRequestDTOMock
                        .getTransferenciaRequestDTO_LimiteDiarioInsuficiente()));
    }

    //TODO - fazer testes restantes para incluir outros cenários do if quando a api retornar todos os cenarios

}