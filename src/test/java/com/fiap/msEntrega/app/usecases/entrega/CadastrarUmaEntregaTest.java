package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.CadastrarUmaEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CadastrarUmaEntregaTest {

    @Test
    @DisplayName("Deve cadastrar uma entrega com sucesso")
    void deveCadastrarUmaEntregaComSucesso() {
        CadastrarUmaEntregaInterface cadastrarUmaEntregaInterface = mock(CadastrarUmaEntregaInterface.class);
        CadastrarUmaEntrega cadastrarUmaEntrega = new CadastrarUmaEntrega(cadastrarUmaEntregaInterface);

        Entrega entrega = new Entrega(1L, "EM_ANDAMENTO", 123L, 456L, 789L);

        when(cadastrarUmaEntregaInterface.cadastrarUmaEntrega(entrega)).thenReturn(entrega);

        Entrega resultado = cadastrarUmaEntrega.cadastrarUmaEntrega(entrega);

        assertEquals(entrega, resultado);
        verify(cadastrarUmaEntregaInterface, times(1)).cadastrarUmaEntrega(entrega);
    }
}
