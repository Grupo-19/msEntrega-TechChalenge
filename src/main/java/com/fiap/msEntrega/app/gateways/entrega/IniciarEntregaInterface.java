package com.fiap.msEntrega.app.gateways.entrega;

import com.fiap.msEntrega.domain.entrega.Entrega;

public interface IniciarEntregaInterface {
    Entrega iniciarEntrega(Long idEntregador, Long idEntrega);
}
