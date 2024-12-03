package com.fiap.msEntrega.infra.controller.entregador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregadorDTOTest {

    @Test
    void testEntregadorDTO() {
        // Criação do DTO
        EntregadorDTO entregadorDTO = new EntregadorDTO(1L, "John Doe", "12345678901");

        // Verificando os valores dos campos
        assertEquals(1L, entregadorDTO.id());
        assertEquals("John Doe", entregadorDTO.nome());
        assertEquals("12345678901", entregadorDTO.cpf());
    }
}
