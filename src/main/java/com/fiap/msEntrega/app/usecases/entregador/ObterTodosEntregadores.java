package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.ObterTodosEntregadoresInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;

import java.util.List;

public class ObterTodosEntregadores {

    private final ObterTodosEntregadoresInterface obterTodosEntregadoresInterface;

    public ObterTodosEntregadores(ObterTodosEntregadoresInterface obterTodosEntregadoresInterface) {
        this.obterTodosEntregadoresInterface = obterTodosEntregadoresInterface;
    }

    public List<Entregador> obterTodosEntregadores(){
        return obterTodosEntregadoresInterface.obterTodosEntregadores();
    }
}
