package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.ExcluirEntregadorInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirEntregadorTest {

    @Test
    @DisplayName("Deve excluir um entregador com sucesso")
    void deveExcluirEntregadorComSucesso() {
        ExcluirEntregadorInterface excluirEntregadorInterface = mock(ExcluirEntregadorInterface.class);
        ExcluirEntregador excluirEntregador = new ExcluirEntregador(excluirEntregadorInterface);

        Long idEntregador = 1L;

        doNothing().when(excluirEntregadorInterface).excluirEntregador(idEntregador);

        excluirEntregador.excluirEntregador(idEntregador);

        verify(excluirEntregadorInterface, times(1)).excluirEntregador(idEntregador);
    }
}
