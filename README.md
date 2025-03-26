# Projeto de Automação de Testes Web - Java + Selenium + Cucumber (Gherkin)

Este projeto tem como objetivo realizar a automação de testes Web utilizando Java, Selenium WebDriver e Cucumber (Gherkin), seguindo o padrão Page Object Model (POM).

## 🧰 Tecnologias Utilizadas
- Java 17+
- Maven
- Selenium WebDriver
- Cucumber (Gherkin)
- GitHub Actions (CI)

## 🗂️ Estrutura de Diretórios
```
├── .github/workflows
│   └── ci.yml               # Pipeline de CI com GitHub Actions
├── src
│   ├── main
│   │   └── java
│   │       └── pages        # Page Objects
│   └── test
│       ├── java
│       │   ├── runners      # Classes de execução dos testes
│       │   └── steps        # Definições dos passos do Cucumber
│       └── resources
│           └── features     # Arquivos .feature (Gherkin)
├── pom.xml                  # Configuração do projeto Maven
└── README.md                # Instruções do projeto
```

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Passos para Configuração
1. Clone este repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
2. Compile o projeto:
```bash
mvn clean compile
```
3. Execute os testes:
```bash
mvn test
```

## 🔁 Integração Contínua com GitHub Actions

### Arquivo `.github/workflows/ci.yml`
```yaml
name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout código
      uses: actions/checkout@v3

    - name: Instalar Java
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'

    - name: Build com Maven
      run: mvn clean compile

    - name: Executar testes
      run: mvn test
```

## ✅ Boas Práticas
- Separe bem as responsabilidades entre Features, Steps e Pages.
- Use variáveis de ambiente para dados sensíveis.
- Utilize waits explícitos quando necessário para evitar flakiness.
- Utilize o padrão Page Object para reuso e organização.

---

## 📬 Contato
Desenvolvido por **Guilherme Neto Franco**

Fique à vontade para abrir issues ou pull requests com melhorias. 🚀
