package com.fiap.msEntrega.infra.gateways.entregador;

import com.fiap.msEntrega.domain.entregador.Entregador;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregadorMapperTest {

    private EntregadorMapper entregadorMapper;

    @BeforeEach
    void setUp() {
        entregadorMapper = new EntregadorMapper();
    }

    @Test
    void testToDomain() {
        EntregadorEntity entity = new EntregadorEntity();
        entity.setId(1L);
        entity.setNome("John Doe");
        entity.setCpf("12345678901");

        Entregador entregador = entregadorMapper.toDomain(entity);

        assertNotNull(entregador);
        assertEquals(entity.getId(), entregador.getId());
        assertEquals(entity.getNome(), entregador.getNome());
        assertEquals(entity.getCpf(), entregador.getCpf());
    }

    @Test
    void testToEntity() {
        Entregador entregador = new Entregador(1L, "John Doe", "12345678901");

        EntregadorEntity entity = entregadorMapper.toEntity(entregador);

        assertNotNull(entity);
        assertEquals(entregador.getId(), entity.getId());
        assertEquals(entregador.getNome(), entity.getNome());
        assertEquals(entregador.getCpf(), entity.getCpf());
    }
}
