package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.ConsultarMelhorRotaInterface;

public class ConsultarMelhorRota {
    private final ConsultarMelhorRotaInterface consultarMelhorRotaInterface;

    public ConsultarMelhorRota(ConsultarMelhorRotaInterface consultarMelhorRotaInterface) {
        this.consultarMelhorRotaInterface = consultarMelhorRotaInterface;
    }

    public String consultarMelhorRota(Long idEndereco) {
        return consultarMelhorRotaInterface.consultarMelhorEndereco(idEndereco);
    }
}
