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

## 🚀 Como rodar o projeto

### Pré-requisitos

- Java 17+
- Maven 3.8+
- IDE como IntelliJ ou VSCode
- Postman (para testar os endpoints)

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/vacancy-management.git

# Entre na pasta
cd vacancy-management

# Execute o projeto
./mvnw spring-boot:run

🔑 Autenticação
A API utiliza JWT e dois filtros personalizados:

Tipo	Endpoint de login	Header necessário	Prefixo obrigatório
Candidato	POST /candidate/auth	Authorization: Bearer	Sim
Empresa	POST /company/auth	Authorization: Bearer	Sim

Após login, você receberá um token JWT que deve ser usado nos próximos requests protegidos.

🛣️ Endpoints principais
📍 Candidato
Método	Rota	Descrição	Autenticado
POST	/candidate/	Criar candidato	❌
POST	/candidate/auth	Login candidato	❌
GET	/candidate/	Ver perfil do candidato logado	✅ ROLE_CANDIDATE

📍 Empresa
Método	Rota	Descrição	Autenticado
POST	/company/	Criar empresa	❌
POST	/company/auth	Login empresa	❌
POST	/company/job/	Criar vaga (job)	✅ ROLE_COMPANY

🧠 Segurança
As rotas estão protegidas com @PreAuthorize("hasRole('...')").

Cada tipo de usuário possui um filtro próprio:

SecurityCandidate → protege rotas com prefixo /candidate

SecurityFilter → protege rotas com prefixo /company

Tokens são validados via JWTCandidateProvider e JWTProvider.

🧪 Testando com Postman
Criar uma empresa ou candidato

Autenticar e salvar o token retornado
