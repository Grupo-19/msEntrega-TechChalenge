package com.fiap.msEntrega.app.usecases.entregador;

import com.fiap.msEntrega.app.gateways.entregador.EditarEntregadorInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;

public class EditarEntregador {

    private final EditarEntregadorInterface editarEntregadorInterface;

    public EditarEntregador(EditarEntregadorInterface editarEntregadorInterface) {
        this.editarEntregadorInterface = editarEntregadorInterface;
    }

    public Entregador editarEntregador(Entregador entregador) {
        return editarEntregadorInterface.editarEntregador(entregador);
    }
}
