package com.desafioitau.api.transferencia.controller;

import com.desafioitau.api.transferencia.domain.helper.TransferenciaHelper;
import com.desafioitau.api.transferencia.domain.mock.TransferenciaRequestDTOMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransferenciaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TransferenciaController controller;

    @Mock
    private TransferenciaHelper helper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void deveRetornar400() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transferencia");
        requestBuilder.contentType(MediaType.APPLICATION_JSON);

        ResultActions resultActions = mockMvc.perform(requestBuilder);
        resultActions.andExpect(MockMvcResultMatchers.status().is4xxClientError());

        assertNotNull(controller.efetuarTransferencia(TransferenciaRequestDTOMock.getTransferenciaRequestDTO_Ok()));
    }
}