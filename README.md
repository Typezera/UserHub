# 🚀 UserHub API

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, tarefas e sistema de amizade, com autenticação segura via **JWT** e ambiente totalmente containerizado com **Docker**.

---

## 📌 Sobre o projeto

O **UserHub** é uma aplicação backend que simula um sistema real com:

* Autenticação e autorização com JWT
* Controle de acesso por **roles (USER / ADMIN)**
* CRUD completo de tarefas por usuário
* Sistema de amizade entre usuários
* Documentação interativa com Swagger
* Banco de dados MySQL rodando em container

---

## 🧠 Funcionalidades

### 🔐 Autenticação e Segurança

* Cadastro de usuário
* Login com geração de token JWT
* Proteção de rotas com Spring Security
* Controle de acesso com roles (`USER` e `ADMIN`)

---

### 👤 Usuários

* Criar conta
* Atualizar dados (com validação de ownership)
* ADMIN pode gerenciar outros usuários
* USER pode gerenciar apenas sua própria conta

---

### 📋 Tarefas

* Criar tarefa vinculada ao usuário logado
* Listar tarefas do usuário
* Atualizar tarefa (PATCH)
* Deletar tarefa
* Validação para garantir que apenas o dono pode modificar

---

### 🤝 Sistema de Amizade

* Enviar solicitação de amizade
* Listar solicitações recebidas (status PENDENTE)
* Aceitar solicitação
* Rejeitar solicitação
* Listar amizades aceitas
* Validação para:

  * evitar duplicidade
  * impedir auto-solicitação
  * garantir fluxo correto (sender → receiver)

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```text
controller → service → repository → database
```

Além disso:

* Uso de **DTOs** para controle de entrada e saída
* Separação de responsabilidades
* Regras de negócio centralizadas no service

---

## 🛠️ Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Security
* JWT (Json Web Token)
* Spring Data JPA / Hibernate
* MySQL
* Docker / Docker Compose
* Swagger (OpenAPI)
* Maven

---

## 🐳 Executando com Docker

### 🔹 Pré-requisitos

* Docker instalado

---

### 🔹 Subir a aplicação

```bash
docker compose up --build
```

---

### 🔹 Acessos

* API:

```text
http://localhost:8080
```

* Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Autenticação no Swagger

1. Realize o login
2. Copie o token JWT
3. Clique em **Authorize 🔒**
4. Insira:

```text
Bearer SEU_TOKEN
```

---

## 🗄️ Banco de Dados

* MySQL rodando em container
* Comunicação interna via Docker Network
* Persistência pode ser adicionada via volumes

---

## 📦 Estrutura do projeto

```text
src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── security
 ├── exception
```

---

## ⚙️ Execução local (sem Docker)

```bash
mvn clean package -DskipTests
java -jar target/*.jar
```

## 💡 Diferenciais do projeto

* Segurança com JWT
* Controle de acesso por roles
* Validação de ownership
* Sistema de relacionamento entre usuários
* API documentada com Swagger
* Ambiente 100% containerizado

---

## 👨‍💻 Autor

Projeto desenvolvido para fins de estudo e portfólio, com foco em backend moderno utilizando **Spring Boot + Docker**.

---

## 📄 Licença

Uso educacional.
