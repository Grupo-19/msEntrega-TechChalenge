package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.CadastrarUmaEntregaInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;

public class CadastrarUmaEntrega {
    private final CadastrarUmaEntregaInterface cadastrarUmaEntregaInterface;

    public CadastrarUmaEntrega(CadastrarUmaEntregaInterface cadastrarUmaEntregaInterface) {
        this.cadastrarUmaEntregaInterface = cadastrarUmaEntregaInterface;
    }

    public Entrega cadastrarUmaEntrega(Entrega entrega) {
        return cadastrarUmaEntregaInterface.cadastrarUmaEntrega(entrega);
    }
}
