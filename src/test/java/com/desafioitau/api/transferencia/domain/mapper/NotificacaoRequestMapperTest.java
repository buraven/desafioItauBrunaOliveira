package com.desafioitau.api.transferencia.domain.mapper;

import com.desafioitau.api.transferencia.domain.mock.TransferenciaRequestDTOMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NotificacaoRequestMapperTest {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void dataMapper() {
        assertNotNull(NotificacaoRequestMapper.dataMapper(TransferenciaRequestDTOMock.getTransferenciaRequestDTO_Ok()));
    }

}