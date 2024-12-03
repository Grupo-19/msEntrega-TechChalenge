package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.ConsultarMelhorRotaInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsultarMelhorRotaTest {

    @Test
    @DisplayName("Deve consultar a melhor rota com sucesso")
    void deveConsultarMelhorRotaComSucesso() {
        ConsultarMelhorRotaInterface consultarMelhorRotaInterface = mock(ConsultarMelhorRotaInterface.class);
        ConsultarMelhorRota consultarMelhorRota = new ConsultarMelhorRota(consultarMelhorRotaInterface);

        Long idEndereco = 123L;
        String rotaEsperada = "Rota ótima para o endereço 123";

        when(consultarMelhorRotaInterface.consultarMelhorEndereco(idEndereco)).thenReturn(rotaEsperada);

        String resultado = consultarMelhorRota.consultarMelhorRota(idEndereco);

        assertEquals(rotaEsperada, resultado);
        verify(consultarMelhorRotaInterface, times(1)).consultarMelhorEndereco(idEndereco);
    }
}
