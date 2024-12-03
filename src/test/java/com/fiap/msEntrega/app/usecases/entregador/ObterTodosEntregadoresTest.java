package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.ObterTodosEntregadoresInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ObterTodosEntregadoresTest {

    @Test
    @DisplayName("Deve obter todos os entregadores com sucesso")
    void deveObterTodosEntregadoresComSucesso() {
        ObterTodosEntregadoresInterface obterTodosEntregadoresInterface = mock(ObterTodosEntregadoresInterface.class);
        ObterTodosEntregadores obterTodosEntregadores = new ObterTodosEntregadores(obterTodosEntregadoresInterface);

        Entregador entregador1 = new Entregador();
        entregador1.setId(1L);
        entregador1.setNome("João Silva");
        entregador1.setCpf("123.456.789-10");

        Entregador entregador2 = new Entregador();
        entregador2.setId(2L);
        entregador2.setNome("Maria Santos");
        entregador2.setCpf("987.654.321-00");

        List<Entregador> entregadoresEsperados = Arrays.asList(entregador1, entregador2);

        when(obterTodosEntregadoresInterface.obterTodosEntregadores()).thenReturn(entregadoresEsperados);

        List<Entregador> resultado = obterTodosEntregadores.obterTodosEntregadores();

        assertEquals(entregadoresEsperados, resultado);
        verify(obterTodosEntregadoresInterface, times(1)).obterTodosEntregadores();
    }
}
