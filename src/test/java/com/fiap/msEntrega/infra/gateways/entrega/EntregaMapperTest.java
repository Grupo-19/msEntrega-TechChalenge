package com.fiap.msEntrega.infra.gateways.entrega;

import com.fiap.msEntrega.domain.entrega.Entrega;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaMapperTest {

    private EntregaMapper entregaMapper;

    @BeforeEach
    void setUp() {
        entregaMapper = new EntregaMapper();
    }

    @Test
    void testToDomain() {
        EntregaEntity entregaEntity = new EntregaEntity();
        entregaEntity.setId(1L);
        entregaEntity.setIdEntregador(2L);
        entregaEntity.setStatus("PENDENTE");
        entregaEntity.setIdPedido(3L);
        entregaEntity.setIdCliente(4L);
        entregaEntity.setIdEndereco(5L);

        Entrega entrega = entregaMapper.toDomain(entregaEntity);

        assertNotNull(entrega);
        assertEquals(entregaEntity.getId(), entrega.getId());
        assertEquals(entregaEntity.getIdEntregador(), entrega.getIdEntregador());
        assertEquals(entregaEntity.getStatus(), entrega.getStatus());
        assertEquals(entregaEntity.getIdPedido(), entrega.getIdPedido());
        assertEquals(entregaEntity.getIdCliente(), entrega.getIdCliente());
        assertEquals(entregaEntity.getIdEndereco(), entrega.getIdEndereco());
    }

    @Test
    void testToEntity() {
        Entrega entrega = new Entrega(1L, 2L, "PENDENTE", 3L, 4L, 5L);

        EntregaEntity entregaEntity = entregaMapper.toEntity(entrega);

        assertNotNull(entregaEntity);
        assertEquals(entrega.getId(), entregaEntity.getId());
        assertEquals(entrega.getIdEntregador(), entregaEntity.getIdEntregador());
        assertEquals(entrega.getStatus(), entregaEntity.getStatus());
        assertEquals(entrega.getIdPedido(), entregaEntity.getIdPedido());
        assertEquals(entrega.getIdCliente(), entregaEntity.getIdCliente());
        assertEquals(entrega.getIdEndereco(), entregaEntity.getIdEndereco());
    }
}
