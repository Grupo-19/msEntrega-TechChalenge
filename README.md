# <h1 align="center"> MICROSSERVIÇO DE ENTREGA </h1>

## Sumário
1. [Visão Geral](#visão-geral)
2. [Design dos Serviços](#design-dos-serviços)
3. [Guia de Implantação](#guia-de-implantação)
4. [Guia de Uso](#guia-de-uso)

---

## 1. Visão Geral

**Descrição**:

Este projeto é parte do **Tech Challenge**, uma atividade integrada e obrigatória para consolidação dos conhecimentos adquiridos em todas as disciplinas da pós-graduação de Arquitetura Java da FIAP. O desafio visa o desenvolvimento de um sistema de **Gerenciamento de Pedidos Integrado com Spring e Microsserviços**, explorando as vantagens dessa arquitetura para construir um sistema robusto, escalável e modular.

Este projeto foi realizado em grupo, composto pelos alunos **Eliane , Valter e Paula**, com o objetivo de aplicar os conceitos aprendidos em um ambiente colaborativo, prático e realista de desenvolvimento.

**Propósito e Objetivo**:

O objetivo do sistema é permitir o gerenciamento completo de pedidos, abrangendo desde a gestão de clientes e produtos até o processamento e entrega dos pedidos. A arquitetura é orientada a microsserviços, cada um responsável por uma parte específica do sistema, o que facilita a manutenção, escalabilidade e distribuição de tarefas entre a equipe. O sistema visa:

- **Gestão eficiente de pedidos**: Controle completo do fluxo de pedidos, desde a criação até a entrega final.
- **Modularidade**: Divisão das responsabilidades em diferentes microsserviços, cada um gerenciando uma parte do processo (clientes, enderecos, produtos, pedidos e entrega).
- **Escalabilidade e Desacoplamento**: Cada microsserviço opera de forma autônoma e possui comunicação assíncrona, permitindo maior resiliência e manutenção simplificada.
- **Utilização de tecnologias de ponta**: Implementação de práticas recomendadas e tecnologias avançadas como Spring Boot, Spring Data JPA, Spring Batch e Spring Cloud Stream para comunicação de eventos.

**Funcionalidades Principais**:

1. **Microsserviço de Gerenciamento de Clientes**: Responsável pelo gerenciamento de dados dos clientes, que é a pessoa que consome o pedido, incluindo funcionalidades de CRUD (criação, leitura, atualização e exclusão) para o cadastro de clientes.
2. **Microsserviço de Gerenciamento de Endereços**: Responsável por coordenar o registro dos enderecos que serao utilizados na entrega, garantindo que serão informados dados validos e sera utilizado apra auxiliar no microsservico de calculo de rotas.
3. **Microsserviço de Catálogo de Produtos**: Encapsula a lógica do catálogo de produtos, permitindo a consulta e atualização de informações dos produtos e controle de estoque. Inclui uma funcionalidade de carga em massa, implementada com Spring Batch, para atualização do inventário a partir de arquivos CSV ou outros formatos.
4. **Microsserviço de Gestão de Pedidos**:  Centraliza a lógica de pedidos, gerenciando a criação, processamento e atualização dos mesmos. Esse serviço realiza integração com o serviço de clientes e produtos para validações e manutenção de estoque.
5. **Microsserviço de Entrega**: Responsável por coordenar a logística de entrega, desde a atribuição de entregadores até o rastreamento das entregas em tempo real, fornecendo atualizações para os clientes.


---

## 2. Endpoints da API, Fluxo e funcionalidades

### Executando Rabbit Mq com o Docker - Passo a passo
Mostrando como executar o Rabbit Mq no docker desktop

[Rodando o Rabbit MQ - Docker](https://elipeixoto.notion.site/Passo-a-passo-Rabbit-Mq-15199b613e8480079a10c4ffdd09f04f)
    

### Executando os microsservicos na IDE

Mostrando os microsservicos sendo executados

[Microsservicos sendo executados](https://elipeixoto.notion.site/Executando-os-microsservicos-15199b613e84800b9585fb51f9013180)



### Video apresentando as funcionalidades sendo executadas

Mostrando os microsservicos sendo executados

[Video evidenciando o microsservico](https://elipeixoto.notion.site/Video-15199b613e84802b9a20dc313ade67d8)

---

## 3. Guia de Implantação


### Requisitos

- **Java**: Versão 11 ou superior
- **Maven**: Para gerenciar as dependências
- **Docker** : Para executar o banco de dados em um container  e o RabbitMQ.

### Passos para Implantação

1. Clone o repositório:
    
    ```bash
    
    git clone https://github.com/usuario/repo.git](https://github.com/Grupo-19/msProduto_TechChalenge)
    cd repo
    
    ```
    

4. Inicie o aplicativo:
    
    ```bash
    mvn spring-boot:run
    
    ```
    
5.  Inicie o banco de dados usando Docker:
    
    ```bash
    
    docker run --name postgres-db -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres
    
    ```
6. inicie o RabbitMQ usando o Docker

```
docker run --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3-management
```

---

## 4. Guia de Uso

[Utilizando os Microsservicos](https://www.youtube.com/watch?v=7x2ZMUsmuAk)
