package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.ExcluirEntregadorInterface;

public class ExcluirEntregador {

    private final ExcluirEntregadorInterface excluirEntregador;

    public ExcluirEntregador(ExcluirEntregadorInterface excluirEntregador) {
        this.excluirEntregador = excluirEntregador;
    }

    public void excluirEntregador(Long id) {
        excluirEntregador.excluirEntregador(id);
    }
}
