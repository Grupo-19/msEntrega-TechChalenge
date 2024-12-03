package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.IniciarEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IniciarEntregaTest {

    @Test
    @DisplayName("Deve iniciar uma entrega com sucesso")
    void deveIniciarUmaEntregaComSucesso() {
        IniciarEntregaInterface iniciarEntregaInterface = mock(IniciarEntregaInterface.class);
        IniciarEntrega iniciarEntrega = new IniciarEntrega(iniciarEntregaInterface);

        Long idEntregador = 1L;
        Long idEntrega = 2L;
        Entrega entregaEsperada = new Entrega();
        entregaEsperada.setId(idEntrega);
        entregaEsperada.setIdEntregador(idEntregador);
        entregaEsperada.setStatus("EM_ANDAMENTO");

        when(iniciarEntregaInterface.iniciarEntrega(idEntregador, idEntrega)).thenReturn(entregaEsperada);

        Entrega resultado = iniciarEntrega.iniciarEntrega(idEntregador, idEntrega);

        assertEquals(entregaEsperada, resultado);
        verify(iniciarEntregaInterface, times(1)).iniciarEntrega(idEntregador, idEntrega);
    }
}
