# Desafio Técnico de Automação Mobile – Appium + Java

---

## Parte 1 – Respostas às Perguntas Teóricas

**1) O cliente adquiriu um novo modelo de máquina de cartão de crédito e ela aceita as bandeiras Visa, Master, Elo, Amex e Hiper e executa duas operações para cada bandeira: débito e crédito. Quantos testes serão necessários para validação dessa máquina e qual técnica a ser utilizada?**

- São 5 bandeiras × 2 operações = **10 testes**.

Explicação:
- A técnica utilizada é o **Particionamento de Equivalência**, que consiste em dividir os dados de entrada em partições ou classes equivalentes.
  Neste caso, cada bandeira e tipo de operação representa uma partição válida que deve ser testada para garantir cobertura adequada do comportamento esperado.

---

**2) A bandeira Visa disponibilizou um novo range de BINs no mercado que possui seis dígitos: 232425 a 232460. Quais os testes deverão ser feitos desse range de BINs para confirmar que está funcionando?**

Alternativas:
a) 230000, 232425, 232460  
b) 0, 232425, 232460, 240000  
c) 232425, 232460  
d) 232424, 232425, 232459, 232460, 232461

**Resposta correta: d) 232424, 232425, 232459, 232460, 232461**

Explicação:
- A técnica correta é a **Análise de Valor Limite**.
- Essa técnica busca validar comportamentos nos extremos dos intervalos válidos e logo fora deles.
- Para o intervalo 232425 a 232460, os testes ideais incluem:
  - Um valor **antes** do início: `232424`
  - O **primeiro valor válido**: `232425`
  - Um valor **dentro** do intervalo: `232459`
  - O **último valor válido**: `232460`
  - Um valor **após** o fim: `232461`

---

**3. Cite uma abordagem ágil e explique com suas palavras.**

- **Scrum** é uma metodologia ágil baseada em ciclos curtos chamados sprints.
- A cada sprint, uma entrega funcional e incremental do sistema é realizada.
- Envolve papéis definidos (Product Owner, Scrum Master, Time de Desenvolvimento) e reuniões como planejamento, review e retrospectiva.

---

**4. O que é CI/CD?**

- **CI (Continuous Integration)**: integração contínua do código com validação por builds automáticos e testes.
- **CD (Continuous Delivery/Deployment)**: entrega automatizada do código validado para ambientes de homologação ou produção.

---

**5. O que é TDD, BDD e ATDD e quando são aplicadas?**

- **TDD (Test-Driven Development)**  
  - Escreve-se o teste antes do código.  
  - Focado em testes unitários.
  - Exemplo: escrever um teste para `calcularDesconto()` antes de implementar o método.

- **BDD (Behavior-Driven Development)**  
  - Focado no comportamento da aplicação.
  - Usa linguagem natural (ex: Gherkin) e cenários.
  - Exemplo:  
    ```
    Dado que o usuário acessa o carrinho  
    Quando adiciona um produto  
    Então o total deve ser atualizado
    ```

- **ATDD (Acceptance Test-Driven Development)**  
  - Envolve time técnico e de negócio definindo critérios antes do desenvolvimento.
  - Exemplo: definir que o CPF deve ser válido e obrigatório antes da criação da tela de cadastro.

---

**6. Cite uma heurística de testes para front e back-end e explique.**

- Front-end:
  - Validar se o usuário consegue inserir, visualizar, editar e excluir dados na interface.
- Back-end/API:
  - Validar se as operações HTTP (POST, GET, PUT, DELETE) funcionam conforme regras de negócio.

---

**7. Ferramentas de testes automatizados por plataforma:**

- **Desktop**: WinAppDriver  
- **Web**: Selenium, Cypress, Playwright  
- **API**: RestAssured, Postman, SoapUI  
- **Mobile**: Appium, Espresso, XCUITest

---

## Parte 2 – Automação Mobile com Appium

**Cenário automatizado:**

- Acessar o aplicativo de contatos Android
- Clicar em adicionar novo contato
- Preencher nome, sobrenome, telefone e e-mail
- Confirmar a criação
- Validar se os dados estão visíveis na tela de detalhes

---

## Tecnologias utilizadas

- Java 17  
- Appium Java Client 9.x  
- JUnit 5  
- Arquitetura baseada em Page Object Model  
- XPath dinâmico parametrizado

---

## Estrutura do Projeto

```
src/
 └── main/
     └── java/
         ├── base/         → BaseTest com setup e teardown
         ├── pages/        → Page Objects (ContactPage, ContactDetailsPage)
         ├── tests/        → Testes automatizados (AddContactTest)
         └── utils/        → Classe Utils (waits, clique, validação de texto)
```

---

## Como executar o projeto

**Pré-requisitos:**
- Java 11 ou superior
- Maven
- Appium Server iniciado (`appium`)
- Emulador ou dispositivo físico configurado
- App de contatos instalado

**Passos:**

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. Inicie o Appium:
```bash
appium
```

3. Execute os testes:
```bash
mvn test
```

---

## Configuração via config.properties

Este projeto utiliza um arquivo de propriedades (`config.properties`) para definir os parâmetros do dispositivo, app package e activity.  
Certifique-se de revisar o arquivo localizado em:

```
src/test/resources/config.properties
```

Parâmetros configuráveis:
- `deviceName`: nome do dispositivo ou emulador (ex: `emulator-5554`)
- `platformName`: plataforma usada (ex: `Android`)
- `automationName`: motor de automação (ex: `UiAutomator2`)
- `appPackage`: pacote do app de contatos
- `appActivity`: activity principal do app

Caso utilize um dispositivo físico ou outro emulador, ajuste o `deviceName` conforme necessário.

## Boas práticas aplicadas

- Separação por camadas: testes, páginas, utilitários
- Uso de Page Object para reaproveitamento e organização
- XPath dinâmico para evitar valores fixos
- Reuso de ações e validações com classe Utils
- Clean Code e princípios de orientação a objetos
- Testes independentes e confiáveis com controle de estado do app

---

## Observações finais

- O projeto cobre todos os passos solicitados na prática de mobile
---