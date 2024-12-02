package com.fiap.msEntrega.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.msEntrega.app.gateways.entrega.*;
import com.fiap.msEntrega.app.usecases.entrega.*;
import com.fiap.msEntrega.infra.gateways.entrega.EntregaMapper;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaHTTP;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaJPA;
import com.fiap.msEntrega.infra.gateways.entrega.RepositorioDeEntregaRabbitMQ;
import com.fiap.msEntrega.infra.persistence.entrega.EntregaRepository;
import com.fiap.msEntrega.infra.persistence.entregador.EntregadorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EntregaConfig {

    @Bean
    CadastrarUmaEntrega cadastrarUmaEntrega(CadastrarUmaEntregaInterface cadastrarUmaEntregaInterface){
        return new CadastrarUmaEntrega(cadastrarUmaEntregaInterface);
    }

    @Bean
    ConsultarMelhorRota consultarMelhorRota(ConsultarMelhorRotaInterface consultarMelhorRotaInterface){
        return new ConsultarMelhorRota(consultarMelhorRotaInterface);
    }

    @Bean
    FinalizarUmaEntrega finalizarUmaEntrega(FinalizarUmaEntregaInterface finalizarUmaEntregaInterface){
        return new FinalizarUmaEntrega(finalizarUmaEntregaInterface);
    }

    @Bean
    IniciarEntrega iniciarEntrega(IniciarEntregaInterface iniciarEntregaInterface){
        return new IniciarEntrega(iniciarEntregaInterface);
    }

    @Bean
    ObterTodasEntregas obterTodasEntregas(ObterTodasEntregasInterface obterTodasEntregasInterface){
        return new ObterTodasEntregas(obterTodasEntregasInterface);
    }

    @Bean
    RepositorioDeEntregaJPA repositorioDeEntregaJPA(EntregaRepository repository, EntregaMapper mapper, EntregadorRepository entregadorRepository, RepositorioDeEntregaRabbitMQ rabbitRepository){
        return new RepositorioDeEntregaJPA(repository, mapper, entregadorRepository, rabbitRepository);
    }

    @Bean
    EntregaMapper entregaMapper(){
        return new EntregaMapper();
    }

    @Bean
    RepositorioDeEntregaHTTP repositorioDeEntregaHTTP(WebClient.Builder webClient, RestTemplate restTemplate, ObjectMapper objectMapper){
        return new RepositorioDeEntregaHTTP(webClient, restTemplate, objectMapper);
    }

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
