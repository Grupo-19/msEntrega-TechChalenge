package com.fiap.msEntrega.config;

import com.fiap.msEntrega.app.gateways.entregador.*;
import com.fiap.msEntrega.app.usecases.entregador.*;
import com.fiap.msEntrega.infra.gateways.entrega.EntregaMapper;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaRabbitMQ;
import com.fiap.msEntrega.infra.gateways.entregador.EntregadorMapper;
import com.fiap.msEntrega.infra.gateways.entregador.RepositorioDeEntregadorJPA;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaRepository;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntregadorConfig {

    @Bean
    CadastrarEntregador cadastrarEntregador(CadastrarEntregadorInterface cadastrarEntregadorInterface) {
        return new CadastrarEntregador(cadastrarEntregadorInterface);
    }

    @Bean
    EditarEntregador editarEntregador(EditarEntregadorInterface editarEntregadorInterface) {
        return new EditarEntregador(editarEntregadorInterface);
    }

    @Bean
    ExcluirEntregador excluirEntregador(ExcluirEntregadorInterface excluirEntregadorInterface){
        return new ExcluirEntregador(excluirEntregadorInterface);
    }

    @Bean
    ObterTodosEntregadores obterTodosEntregadores(ObterTodosEntregadoresInterface obterTodosEntregadores){
        return new ObterTodosEntregadores(obterTodosEntregadores);
    }

    @Bean
    RepositorioDeEntregadorJPA repositorioDeEntregadorJPA(EntregadorRepository repository,
                                                          EntregadorMapper mapper,
                                                          EntregaRepository entregaRepository,
                                                          EntregaMapper entregaMapper,
                                                          RepositorioDeEntregaRabbitMQ rabbitMQ
                                                          ){
        return new RepositorioDeEntregadorJPA(repository, mapper, entregaRepository, entregaMapper, rabbitMQ);
    }

    @Bean
    EntregadorMapper entregadorMapper(){
        return new EntregadorMapper();
    }
}
