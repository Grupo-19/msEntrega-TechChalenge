package com.fiap.msEntrega.app.usecases.entrega;

import com.fiap.msEntrega.app.gateways.entrega.ObterTodasEntregasInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;

import java.util.List;

public class ObterTodasEntregas {

    private final ObterTodasEntregasInterface obterTodasEntregas;

    public ObterTodasEntregas(ObterTodasEntregasInterface obterTodasEntregas) {
        this.obterTodasEntregas = obterTodasEntregas;
    }

    public List<Entrega> obterTodasEntregas() {
        return obterTodasEntregas.obterTodasEntregas();
    }
}
