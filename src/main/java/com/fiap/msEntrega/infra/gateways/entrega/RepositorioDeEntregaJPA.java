package com.fiap.msEntrega.infra.gateways.entrega;

import com.fiap.msEntrega.app.gateways.entrega.CadastrarUmaEntregaInterface;
import com.fiap.msEntrega.app.gateways.entrega.FinalizarUmaEntregaInterface;
import com.fiap.msEntrega.app.gateways.entrega.IniciarEntregaInterface;
import com.fiap.msEntrega.app.gateways.entrega.ObterTodasEntregasInterface;
import com.fiap.msEntrega.domain.entrega.Entrega;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaEntity;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaRepository;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorEntity;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RepositorioDeEntregaJPA implements
        CadastrarUmaEntregaInterface,
        FinalizarUmaEntregaInterface,
        IniciarEntregaInterface,
        ObterTodasEntregasInterface {

    private final EntregaRepository repository;
    private final EntregaMapper mapper;
    private final EntregadorRepository entregadorRepository;
    private final RepositorioDeEntregaRabbitMQ rabbitRepository;

    public RepositorioDeEntregaJPA(EntregaRepository repository, EntregaMapper mapper, EntregadorRepository entregadorRepository, RepositorioDeEntregaRabbitMQ rabbitRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.entregadorRepository = entregadorRepository;
        this.rabbitRepository = rabbitRepository;
    }

    @Override
    public Entrega cadastrarUmaEntrega(Entrega entrega) {
        EntregaEntity entity = mapper.toEntity(entrega);
        entity.setId(null);
        entity.setStatus("Pendente de entrega");
        entity.setIdEntregador(null);
        rabbitRepository.atualizarStatus(mapper.toDomain(entity));
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Entrega finalizarUmaEntrega(Long idEntrega) {
        EntregaEntity entity = repository.findById(idEntrega).orElseThrow(() ->
                new NoSuchElementException("Não foi encontrado uma entrega"));
        entity.setStatus("Finalizada");
        rabbitRepository.atualizarStatus(mapper.toDomain(entity));
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Entrega iniciarEntrega(Long idEntregador, Long idEntrega) {
        EntregaEntity entity = repository.findById(idEntrega).orElseThrow(() ->
                new NoSuchElementException("Não foi encontrado uma entrega"));

        EntregadorEntity entregador = entregadorRepository.findById(idEntregador).orElseThrow(
                () -> new NoSuchElementException("Entregador não encontrado"));

        entity.setIdEntregador(entregador.getId());
        entity.setStatus("Em curso");
        rabbitRepository.atualizarStatus(mapper.toDomain(entity));
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Entrega> obterTodasEntregas() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
