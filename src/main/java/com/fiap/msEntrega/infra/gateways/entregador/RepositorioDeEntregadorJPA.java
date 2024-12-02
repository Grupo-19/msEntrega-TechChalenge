package com.fiap.msEntrega.infra.gateways.entregador;

import com.fiap.msEntrega.app.gateways.entregador.CadastrarEntregadorInterface;
import com.fiap.msEntrega.app.gateways.entregador.EditarEntregadorInterface;
import com.fiap.msEntrega.app.gateways.entregador.ExcluirEntregadorInterface;
import com.fiap.msEntrega.app.gateways.entregador.ObterTodosEntregadoresInterface;
import com.fiap.msEntrega.domain.entregador.Entregador;
import com.fiap.msEntrega.infra.gateways.entrega.EntregaMapper;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaRabbitMQ;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaRepository;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorEntity;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeEntregadorJPA implements
        CadastrarEntregadorInterface,
        EditarEntregadorInterface,
        ExcluirEntregadorInterface,
        ObterTodosEntregadoresInterface {

    private final EntregadorRepository repository;
    private final EntregadorMapper mapper;
    private final EntregaRepository entregaRepository;
    private final EntregaMapper entregaMapper;
    private final RepositorioDeEntregaRabbitMQ rabbitRepository;

    public RepositorioDeEntregadorJPA(EntregadorRepository repository, EntregadorMapper mapper, EntregaRepository entregaRepository, EntregaMapper entregaMapper, RepositorioDeEntregaRabbitMQ rabbitRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.entregaRepository = entregaRepository;
        this.entregaMapper = entregaMapper;
        this.rabbitRepository = rabbitRepository;
    }

    @Override
    public Entregador cadastraEntregador(Entregador entregador) {
        EntregadorEntity entity = mapper.toEntity(entregador);
        entity.setId(null);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Entregador editarEntregador(Entregador entregador) {
        EntregadorEntity entity = mapper.toEntity(entregador);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void excluirEntregador(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Entregador> obterTodosEntregadores() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
