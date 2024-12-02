package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.IniciarEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;

public class IniciarEntrega {

    private final IniciarEntregaInterface iniciarEntregaInterface;

    public IniciarEntrega(IniciarEntregaInterface iniciarEntregaInterface) {
        this.iniciarEntregaInterface = iniciarEntregaInterface;
    }

    public Entrega iniciarEntrega(Long idEntregador, Long idEntrega){
        return  iniciarEntregaInterface.iniciarEntrega(idEntregador, idEntrega);
    }
}
