package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.CadastrarEntregadorInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CadastrarEntregadorTest {

    @Test
    @DisplayName("Deve cadastrar um entregador com sucesso")
    void deveCadastrarEntregadorComSucesso() {
        CadastrarEntregadorInterface cadastrarEntregadorInterface = mock(CadastrarEntregadorInterface.class);
        CadastrarEntregador cadastrarEntregador = new CadastrarEntregador(cadastrarEntregadorInterface);

        Entregador entregador = new Entregador();
        entregador.setId(1L);
        entregador.setNome("João Silva");
        entregador.setCpf("123.456.789-10");

        when(cadastrarEntregadorInterface.cadastraEntregador(entregador)).thenReturn(entregador);

        Entregador resultado = cadastrarEntregador.cadastrarEntregador(entregador);

        assertEquals(entregador, resultado);
        verify(cadastrarEntregadorInterface, times(1)).cadastraEntregador(entregador);
    }
}
