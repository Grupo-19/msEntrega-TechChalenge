package com.fiap.msEntrega.infra.gateways.entrega;

import com.fiap.msEntrega.domain.entrega.Entrega;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaEntity;

public class EntregaMapper {

    public Entrega toDomain(EntregaEntity input){
        return new Entrega(input.getId(),
                input.getIdEntregador(),
                input.getStatus(),
                input.getIdPedido(),
                input.getIdCliente(),
                input.getIdEndereco());
    }

    public EntregaEntity toEntity(Entrega input){
        return new EntregaEntity(input.getId(),
                input.getIdEntregador(),
                input.getStatus(),
                input.getIdPedido(),
                input.getIdCliente(),
                input.getIdEndereco());
    }
}
