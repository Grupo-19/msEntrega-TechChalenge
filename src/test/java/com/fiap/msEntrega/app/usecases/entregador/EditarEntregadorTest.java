package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.EditarEntregadorInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EditarEntregadorTest {

    @Test
    @DisplayName("Deve editar um entregador com sucesso")
    void deveEditarEntregadorComSucesso() {
        EditarEntregadorInterface editarEntregadorInterface = mock(EditarEntregadorInterface.class);
        EditarEntregador editarEntregador = new EditarEntregador(editarEntregadorInterface);

        Entregador entregador = new Entregador();
        entregador.setId(1L);
        entregador.setNome("João Silva");
        entregador.setCpf("123.456.789-10");

        Entregador entregadorEditado = new Entregador();
        entregadorEditado.setId(1L);
        entregadorEditado.setNome("João Santos");
        entregadorEditado.setCpf("123.456.789-10");

        when(editarEntregadorInterface.editarEntregador(entregador)).thenReturn(entregadorEditado);

        Entregador resultado = editarEntregador.editarEntregador(entregador);

        assertEquals(entregadorEditado, resultado);
        verify(editarEntregadorInterface, times(1)).editarEntregador(entregador);
    }
}
