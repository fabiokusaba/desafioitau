# 🏦🟧 Desafio Itaú 

## 📚 Resumo
Desenvolvimento de uma API REST para lidar com transações e gerar um relatório. 

## 🎯 Escopo
Arquitetura em camadas: controller, service, repository.

## 💻 Tecnologias
* Java 21
* Spring Web
* Lombok

## 🌐 Endpoints
* `/transacao`: responsável por lidar com a exclusão e salvamento de uma nova transação.
* `/estatistica`: responsável por lidar com as métricas das transações.

## 📦 Payload
* `{ valor: Double, dataHora: OffsetDateTime }`: DTO para criar uma nova transação.
* `{ count: Long, sum: Double, avg: Double, max: Double, min: Double }`: DTO de resposta para as métricas das transações.