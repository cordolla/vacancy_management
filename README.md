# 🧾 Vacancy Management API

API REST desenvolvida com **Spring Boot** para gerenciamento de vagas de emprego, com autenticação JWT separada para dois tipos de usuários: **candidatos** e **empresas**.

---

## 📌 Funcionalidades

- Cadastro e autenticação de candidatos
- Cadastro e autenticação de empresas
- Criação de vagas por empresas
- Perfil do candidato autenticado
- Segurança com JWT (tokens diferentes para candidatos e empresas)
- Controle de acesso por roles com `@PreAuthorize`

---

## 📦 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (com Auth0)
- Jakarta Validation
- BCrypt (hash de senhas)
- Maven

---
