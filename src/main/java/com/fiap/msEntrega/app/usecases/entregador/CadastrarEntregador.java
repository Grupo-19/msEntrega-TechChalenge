package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.CadastrarEntregadorInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;

public class CadastrarEntregador {

    private final CadastrarEntregadorInterface cadastrarEntregadorInterface;

    public CadastrarEntregador(CadastrarEntregadorInterface cadastrarEntregadorInterface) {
        this.cadastrarEntregadorInterface = cadastrarEntregadorInterface;
    }

    public Entregador cadastrarEntregador(Entregador entregador){
        return cadastrarEntregadorInterface.cadastraEntregador(entregador);
    }
}
