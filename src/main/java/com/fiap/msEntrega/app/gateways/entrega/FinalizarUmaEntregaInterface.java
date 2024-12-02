package com.fiap.msEntrega.app.gateways.entrega;

import com.fiap.msEntrega.domain.entrega.Entrega;

public interface FinalizarUmaEntregaInterface {
    Entrega finalizarUmaEntrega(Long idEntrega);
}
