package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.ObterTodasEntregasInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ObterTodasEntregasTest {

    @Test
    @DisplayName("Deve obter todas as entregas com sucesso")
    void deveObterTodasEntregasComSucesso() {
        ObterTodasEntregasInterface obterTodasEntregasInterface = mock(ObterTodasEntregasInterface.class);
        ObterTodasEntregas obterTodasEntregas = new ObterTodasEntregas(obterTodasEntregasInterface);

        Entrega entrega1 = new Entrega(1L, 2L, "FINALIZADA", 123L, 456L, 789L);
        Entrega entrega2 = new Entrega(2L, 3L, "EM_ANDAMENTO", 124L, 457L, 790L);

        List<Entrega> entregasEsperadas = Arrays.asList(entrega1, entrega2);

        when(obterTodasEntregasInterface.obterTodasEntregas()).thenReturn(entregasEsperadas);

        List<Entrega> resultado = obterTodasEntregas.obterTodasEntregas();

        assertEquals(entregasEsperadas, resultado);
        verify(obterTodasEntregasInterface, times(1)).obterTodasEntregas();
    }
}
