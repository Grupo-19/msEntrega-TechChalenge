package com.fiap.msEntrega.infra.controller.entrega;

public record EntregaDTO(
        Long id,
        Long idEntregador,
        String status,
        Long idPedido,
        Long idCliente,
        Long idEndereco
) {
}
