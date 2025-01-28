# Bootcamp spring professional

---

- Componentes e Injeção de Dependência

- Estruturação de projeto, camadas

- Modelo de Domínio

- Relacionamentos

- Mapeamento objeto relacional

- API Rest

- Tratamento de exceções

- Validação de dados

- Consultas ao banco de dados

- Transações

- Login e controle de acesso

- OAuth2, JWT

- Variáveis de ambiente

- Perfis de projeto

- Ambiente local, homologação

- Implantação, CI/CD

---

### Grade curricular / ementas

- Componentes e injeção de dependência

  - Preparação de ambiente
  - Sistema e componentes
  - Inversão de controle e injeção de dependência
  - Trocando a dependência sem abrir o componente pai
  - Frameworks
  - Criação de projeto Spring Boot
  - Implementação de componentes no Spring Boot
  - DESAFIO: Componentes e Injeção de Dependência

- Modelo de Domínio e ORM
  - Revisão de Álgebra Relacional e SQL
  - Super revisão de OO e SQL com Java e JDBC
  - Nivelamento ORM - JPA e Hibernate
  - Documento de requisitos do sistema DSCommerce
  - Criando o projeto Spring Boot
  - Entidade User, banco H2
  - Order, Enum, relacionamento muitos-para-um
  - Payment, relacionamento um-para-um
  - Muitos-para-muitos, column unique e text
  - Muitos-para-muitos com classe de associação PARTE 1
  - Muitos-para-muitos com classe de associação PARTE 2
  - Seeding da base de dados
  - DESAFIO: Modelo de domínio e ORM

* API REST, camadas, CRUD, exceções, validações

  - O que é uma API REST
  - Recursos, URL, parâmetros de consulta e de rota
  - Padrões de URL, verbos HTTP, códigos de resposta
  - Padrão camadas
  - Acessando API
  - Repository
  - Criando DTO e estruturando camadas
  - Dica da biblioteca ModelMapper para DTO
  - CRUD
  - Busca paginada
  - Inserção com POST
  - Customizando resposta com ResponseEntity
  - Atualização com PUT
  - Deleção com DELETE
  - Criando exceções de serviço customizadas
  - Tratando exceção com resposta customizada
  - Validação com Bean Validation
  - Customizando a resposta da validação
  - DESAFIO: CRUD de clientes

* JPA, consultas SQL e JPQL

  - Sessão JPA e estados de entidades
  - Salvando entidade associada para um
  - Salvando entidades associadas para muitos
  - Evitando degradação de performance
  - Carregamento EAGER e LAZY
  - Analisando o carregamento lazy de entidades
  - Alterando o atributo fetch dos relacionamentos
  - Otimizando consultas com a cláusula JOIN FETCH
  - Entendendo Transactional e open-in-view
  - Consultas com Query Methods
  - Introdução sobre JPQL
  - Polêmica vale a pena especializar na JPQL
  - Preparando para os estudos de caso de consultas
  - Estudo de caso URI 2602: consulta simples
  - Estudo de caso URI 2611: INNER JOIN
  - Estudo de caso URI 2621: BETWEEN LIKE
  - Estudo de caso URI 2609: GROUP BY
  - Estudo de caso URI 2737: UNION ALL, LEFT JOIN
  - Estudo de caso URI 2990: NOT IN
  - Estudo de caso: DSCommerce consulta de produtos por nome
  - DESAFIO: Consulta vendas

* Login e controle de acesso

  - Ideia geral do login e controle de acesso
  - Visão geral do OAuth2
  - Login, credenciais e JWT
  - Preparando projeto com bibliotecas
  - Modelo de dados User e Role
  - UserDetails, GrantedAuthority, UserDetailsService
  - Armazenamento da senha codificada com BCrypt
  - Checklist do OAuth2 com JWT no Spring Boot
  - Requisição de login no Postman
  - Deixando o Postman top
  - Acessando recursos protegidos
  - Controle de acesso aos endpoints
  - Variáveis de ambiente no projeto
  - Configuração de CORS
  - Obtendo usuário logado
  - Controle de acesso programático self ou admin
  - Endpoint para buscar categorias
  - DESAFIO: Projeto Spring Boot estruturado

* Homologação e implantação com CI/CD
  - Setup do ambiente local Postgresql e pgAdmin com \* Docker e Docker Compose
  - Perfis de projeto: test, dev, prod
  - Profile dev para homologação Postgresql
  - Profile prod para projeto em produção na nuvem
  - Geração de script de criação e seed da base de dados
  - Procedimento deploy com CI/CD no Heroku
  - Procedimento deploy com CI/CD no Railway

---

![Certificado](img/devsuperior-bootcamp-professional.jpg)
