package com.fiap.msEntrega.infra.gateways.entregador;

import com.fiap.msEntrega.domain.entregador.Entregador;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorEntity;

public class EntregadorMapper {

    public Entregador toDomain(EntregadorEntity input) {
        return new Entregador(input.getId(),
                input.getNome(),
                input.getCpf()
        );
    }

    public EntregadorEntity toEntity(Entregador input) {
        return new EntregadorEntity(input.getId(),
                input.getNome(),
                input.getCpf()
        );
    }
}
