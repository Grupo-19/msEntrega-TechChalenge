package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.FinalizarUmaEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FinalizarUmaEntregaTest {

    @Test
    @DisplayName("Deve finalizar uma entrega com sucesso")
    void deveFinalizarUmaEntregaComSucesso() {
        FinalizarUmaEntregaInterface finalizarUmaEntregaInterface = mock(FinalizarUmaEntregaInterface.class);
        FinalizarUmaEntrega finalizarUmaEntrega = new FinalizarUmaEntrega(finalizarUmaEntregaInterface);

        Long idEntrega = 1L;
        Entrega entregaEsperada = new Entrega();
        entregaEsperada.setId(idEntrega);
        entregaEsperada.setStatus("FINALIZADA");

        when(finalizarUmaEntregaInterface.finalizarUmaEntrega(idEntrega)).thenReturn(entregaEsperada);

        Entrega resultado = finalizarUmaEntrega.finalizarUmaEntrega(idEntrega);

        assertEquals(entregaEsperada, resultado);
        verify(finalizarUmaEntregaInterface, times(1)).finalizarUmaEntrega(idEntrega);
    }
}
