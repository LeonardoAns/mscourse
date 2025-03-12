<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projeto de Microsserviços</title>
</head>
<body>
    <h1>Projeto de Microsserviços</h1>
    <h2>Descrição</h2>
    <p>Este projeto foi desenvolvido durante um curso de microsserviços e tem como objetivo demonstrar a implementação de uma arquitetura baseada em serviços independentes e escaláveis. Utiliza diversas tecnologias para garantir comunicação eficiente, descoberta de serviços e gerenciamento de dados.</p>
    <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li>Java 17 - Linguagem principal do projeto</li>
        <li>Spring Boot - Framework para desenvolvimento dos microsserviços</li>
        <li>Spring Cloud - Conjunto de ferramentas para microsserviços</li>
        <li>Eureka Server - Registro e descoberta de serviços</li>
        <li>Spring Cloud Gateway - API Gateway para roteamento e segurança</li>
        <li>RabbitMQ - Mensageria para comunicação assíncrona entre microsserviços</li>
        <li>JPA (Hibernate) - ORM para interação com banco de dados</li>
        <li>PostgreSQL - Banco de dados relacional</li>
        <li>Docker - Containerização dos microsserviços</li>
    </ul>
    <h2>Estrutura do Projeto</h2>
    <p>O projeto segue uma abordagem modularizada, com os seguintes serviços:</p>
    <ul>
        <li>Eureka Server - Servidor de descoberta de serviços</li>
        <li>API Gateway - Gerencia as requisições para os microsserviços</li>
        <li>Serviço de Usuários - Gerencia informações e registro de usuários</li>
        <li>Serviço de Cartões - Gerencia registro de cartões e recupera cartões por cpf ou renda</li>
        <li>Serviço de Crédito - Avalia o perfil do usuário e aprova a liberação de um cartão de crédito conforme critérios definidos.</li>
        <li>Mensageria - Utiliza RabbitMQ para troca de mensagens assíncronas</li>
    </ul>
</body>
</html>
