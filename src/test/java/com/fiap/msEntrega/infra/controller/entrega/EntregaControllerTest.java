package com.fiap.msEntrega.infra.controller.entrega;

import com.fiap.msEntrega.app.usecases.entrega.*;
import com.fiap.msEntrega.domain.entrega.Entrega;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EntregaController.class)
@Import(EntregaControllerIntegrationTest.TestConfig.class)
class EntregaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CadastrarUmaEntrega cadastrarUmaEntrega;

    @Autowired
    private ConsultarMelhorRota consultarMelhorRota;

    @Autowired
    private FinalizarUmaEntrega finalizarUmaEntrega;

    @Autowired
    private IniciarEntrega iniciarEntrega;

    @Autowired
    private ObterTodasEntregas obterTodasEntregas;

    @BeforeEach
    void setup() {
        Mockito.reset(
                cadastrarUmaEntrega,
                consultarMelhorRota,
                finalizarUmaEntrega,
                iniciarEntrega,
                obterTodasEntregas
        );
    }

    @Test
    void testReceberEntrega() throws Exception {
        Entrega entrega = new Entrega(1L, 2L, "PENDENTE", 3L, 4L, 5L);

        Mockito.when(cadastrarUmaEntrega.cadastrarUmaEntrega(Mockito.any()))
                .thenReturn(entrega);

        String requestBody = """
                {
                    "id": 1,
                    "idEntregador": 2,
                    "status": "PENDENTE",
                    "idPedido": 3,
                    "idCliente": 4,
                    "idEndereco": 5
                }
                """;

        mockMvc.perform(post("/entrega")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.idEntregador", is(2)))
                .andExpect(jsonPath("$.status", is("PENDENTE")));
    }

    @Test
    void testConsultarMelhorRota() throws Exception {
        Mockito.when(consultarMelhorRota.consultarMelhorRota(1L))
                .thenReturn("Melhor Rota: Rua A, Rua B, Rua C");

        mockMvc.perform(get("/entrega/rotas")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Melhor Rota: Rua A, Rua B, Rua C"));
    }

    @Test
    void testFinalizarEntrega() throws Exception {
        Entrega entrega = new Entrega(1L, 2L, "FINALIZADA", 3L, 4L, 5L);

        Mockito.when(finalizarUmaEntrega.finalizarUmaEntrega(1L))
                .thenReturn(entrega);

        mockMvc.perform(put("/entrega/finalizar")
                        .param("idEntrega", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("FINALIZADA")));
    }

    @Test
    void testIniciarEntrega() throws Exception {
        Entrega entrega = new Entrega(1L, 2L, "EM_ANDAMENTO", 3L, 4L, 5L);

        Mockito.when(iniciarEntrega.iniciarEntrega(2L, 1L))
                .thenReturn(entrega);

        mockMvc.perform(put("/entrega/iniciar")
                        .param("idEntregador", "2")
                        .param("idEntrega", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("EM_ANDAMENTO")));
    }

    @Test
    void testListarEntregas() throws Exception {
        Entrega entrega = new Entrega(1L, 2L, "PENDENTE", 3L, 4L, 5L);

        Mockito.when(obterTodasEntregas.obterTodasEntregas())
                .thenReturn(Collections.singletonList(entrega));

        mockMvc.perform(get("/entrega"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].status", is("PENDENTE")));
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public CadastrarUmaEntrega cadastrarUmaEntrega() {
            return mock(CadastrarUmaEntrega.class);
        }

        @Bean
        public ConsultarMelhorRota consultarMelhorRota() {
            return mock(ConsultarMelhorRota.class);
        }

        @Bean
        public FinalizarUmaEntrega finalizarUmaEntrega() {
            return mock(FinalizarUmaEntrega.class);
        }

        @Bean
        public IniciarEntrega iniciarEntrega() {
            return mock(IniciarEntrega.class);
        }

        @Bean
        public ObterTodasEntregas obterTodasEntregas() {
            return mock(ObterTodasEntregas.class);
        }
    }
}
