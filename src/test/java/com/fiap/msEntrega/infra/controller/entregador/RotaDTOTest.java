package com.fiap.msEntrega.infra.controller.entregador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RotaDTOTest {

    @Test
    void testRotaDTOInstantiation() {
        // Criação do DTO vazio
        RotaDTO rotaDTO = new RotaDTO();

        // Verificando se o objeto foi instanciado corretamente
        assertNotNull(rotaDTO);
    }
}
