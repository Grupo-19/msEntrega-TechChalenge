package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.FinalizarUmaEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;

public class FinalizarUmaEntrega {

    private final FinalizarUmaEntregaInterface finalizarUmaEntregaInterface;

    public FinalizarUmaEntrega(FinalizarUmaEntregaInterface finalizarUmaEntregaInterface) {
        this.finalizarUmaEntregaInterface = finalizarUmaEntregaInterface;
    }

    public Entrega finalizarUmaEntrega(Long idEntrega) {
        return finalizarUmaEntregaInterface.finalizarUmaEntrega(idEntrega);
    }
}
