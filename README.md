# tarefas-api
Atividade prática desenvolvimento back end uninter
Ramon Colonetti
RU: 4676346
# API de Tarefas

API RESTful para **gerenciamento de tarefas**, desenvolvida em **Java Spring Boot** com **MySQL**.  
Permite criar, consultar, atualizar e deletar tarefas.

---

##  Tecnologias utilizadas
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Postman (para testes)

---

##  Funcionalidades
- **Criar tarefa** → POST `/tarefas`
- **Listar todas as tarefas** → GET `/tarefas`
- **Buscar tarefa por ID** → GET `/tarefas/{id}`
- **Atualizar tarefa** → PUT `/tarefas/{id}`
- **Remover tarefa** → DELETE `/tarefas/{id}`

---

##  Estrutura do projeto
tarefas-api/
├─ src/main/java/com/exemplo/tarefas
│ ├─ model/Tarefa.java
│ ├─ repository/TarefaRepository.java
│ └─ controller/TarefaController.java
├─ src/main/resources/application.properties
└─ pom.xml


##  Configuração do banco de dados
1. Criar o banco no MySQL:

```sql
CREATE DATABASE tarefasdb;
