package com.fiap.msEntrega.infra.gateways.entregador;

import com.fiap.msEntrega.domain.entregador.Entregador;
import com.fiap.msEntrega.infra.gateways.entrega.EntregaMapper;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorEntity;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorRepository;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaRepository;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaRabbitMQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepositorioDeEntregadorJPATest {

    @Mock
    private EntregadorRepository entregadorRepository;

    @Mock
    private EntregaRepository entregaRepository;

    @Mock
    private EntregadorMapper entregadorMapper;

    @Mock
    private EntregaMapper entregaMapper;

    @Mock
    private RepositorioDeEntregaRabbitMQ rabbitRepository;

    @InjectMocks
    private RepositorioDeEntregadorJPA repositorioDeEntregadorJPA;

    private EntregadorEntity entregadorEntity;
    private Entregador entregador;

    @BeforeEach
    void setUp() {
        entregadorEntity = new EntregadorEntity();
        entregadorEntity.setId(1L);
        entregadorEntity.setNome("John Doe");
        entregadorEntity.setCpf("12345678901");

        entregador = new Entregador(1L, "John Doe", "12345678901");
    }

    @Test
    void testCadastraEntregador() {
        when(entregadorMapper.toEntity(any())).thenReturn(entregadorEntity);
        when(entregadorRepository.save(any())).thenReturn(entregadorEntity);
        when(entregadorMapper.toDomain(any())).thenReturn(entregador);

        Entregador result = repositorioDeEntregadorJPA.cadastraEntregador(entregador);

        assertNotNull(result);
        assertEquals(entregador.getId(), result.getId());
        assertEquals(entregador.getNome(), result.getNome());
        assertEquals(entregador.getCpf(), result.getCpf());
    }

    @Test
    void testEditarEntregador() {
        when(entregadorMapper.toEntity(any())).thenReturn(entregadorEntity);
        when(entregadorRepository.save(any())).thenReturn(entregadorEntity);
        when(entregadorMapper.toDomain(any())).thenReturn(entregador);

        Entregador result = repositorioDeEntregadorJPA.editarEntregador(entregador);

        assertNotNull(result);
        assertEquals(entregador.getId(), result.getId());
        assertEquals(entregador.getNome(), result.getNome());
        assertEquals(entregador.getCpf(), result.getCpf());
    }

    @Test
    void testExcluirEntregador() {
        doNothing().when(entregadorRepository).deleteById(anyLong());

        repositorioDeEntregadorJPA.excluirEntregador(1L);

        verify(entregadorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testObterTodosEntregadores() {
        when(entregadorRepository.findAll()).thenReturn(List.of(entregadorEntity));
        when(entregadorMapper.toDomain(any())).thenReturn(entregador);

        List<Entregador> result = repositorioDeEntregadorJPA.obterTodosEntregadores();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testObterTodosEntregadores_EmptyList() {
        when(entregadorRepository.findAll()).thenReturn(List.of());

        List<Entregador> result = repositorioDeEntregadorJPA.obterTodosEntregadores();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
