# PetFriends - Microsserviços de Gerenciamento de Clientes, Estoque e Transporte

## **Descrição do Projeto**
Este projeto é uma aplicação baseada em microsserviços para gerenciar clientes, produtos e pedidos da PetFriends.  
Ele foi desenvolvido com Spring Boot, Spring Data JPA e Hibernate Envers para auditoria, seguindo boas práticas de DDD (Domain-Driven Design) e arquitetura de microsserviços.

O objetivo é permitir:

- Gerenciar clientes (CRUD completo).  
- Controlar estoque e produtos do Almoxarifado.  
- Gerenciar pedidos e logística de transporte.  
- Consultar histórico de alterações de dados (auditoria).  
- Garantir rastreabilidade e observabilidade usando Spring Cloud Sleuth, Zipkin e ELK Stack.

---

## **Tecnologias Utilizadas**

- **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate Envers  
- **Frontend:** ReactJS (para PetFriends_Web)  
- **Banco de Dados:** H2 (para testes) ou outro banco relacional à escolha  
- **Mensageria:** RabbitMQ / Kafka (event-driven)  
- **Observabilidade:** Spring Cloud Sleuth, Zipkin, ELK Stack  
- **Controle de versão:** Git/GitHub

---

## **Estrutura do Projeto**

- **PetFriends_Clientes:** microsserviço responsável por clientes.  
- **PetFriends_Almoxarifado:** microsserviço responsável pelo estoque e produtos.  
- **PetFriends_Transporte:** microsserviço responsável pela logística de entregas.  
- **PetFriends_Pedidos:** microsserviço que gerencia pedidos e envia eventos para Almoxarifado e Transporte.  
- **PetFriends_Web:** frontend em ReactJS, consumindo os microsserviços via REST.

---

## **Funcionalidades**

### **CRUD de Clientes**
- Criar, listar, atualizar e deletar clientes.
- Consultar histórico de alterações de clientes.

### **Gestão de Estoque**
- Registrar produtos e quantidades disponíveis.
- Atualizar estoque automaticamente via eventos de pedidos.

### **Transporte**
- Receber pedidos e iniciar logística de entrega.
- Atualizar status de entrega com base nos eventos de pedidos.

### **Auditoria**
- Registrar todas as alterações de dados importantes.
- Consultar revisões passadas de clientes, produtos e pedidos.

### **Event-Driven**
- Eventos disparados pelos pedidos informam Almoxarifado e Transporte.
- Comunicação assíncrona para desacoplar os microsserviços.

