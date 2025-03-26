# Introdução à Disciplina de Desenvolvimento de Sistemas Web

### Arquitetura Cliente/Servidor

A arquitetura cliente/servidor é um modelo fundamental em sistemas web. Nesse modelo:

- **Cliente**: É o dispositivo ou aplicação que solicita serviços (como navegadores ou aplicativos).
- **Servidor**: É responsável por atender às solicitações do cliente, processando dados e devolvendo respostas (como páginas web, arquivos, ou resultados de consultas a bancos de dados).

Funcionamento básico:
1. O cliente envia uma **requisição** ao servidor.
2. O servidor processa a requisição e prepara a **resposta**.
3. A resposta é enviada ao cliente, exibida no navegador ou na aplicação.

Esse modelo garante uma separação clara entre os papéis, permitindo escalabilidade e eficiência.

---

### URI (Uniform Resource Identifier) e URL (Uniform Resource Locator)

- **URI** é um identificador genérico de recursos, como um nome ou endereço.
- **URL** é um tipo específico de URI que identifica a **localização** de um recurso na web.

    #### Diferenças entre URI e URL:

    | Conceito     | URI                           | URL                          |
    |--------------|-------------------------------|------------------------------|
    | **Definição** | Identifica recursos          | Localiza recursos na web     |
    | **Abrangência** | Identificador genérico      | Indica localização completa  |
    | **Usos**      | Define e rastreia recursos   | Ideal para links na internet |

#### Exemplos:
- **URI**: `urn:isbn:0451450523` (identifica um livro pelo ISBN).
- **URL**: `https://www.example.com/index.html` (indica a localização de uma página web).

**URN** (Uniform Resource Name) é um subconjunto de URI, identificando um recurso por nome em namespaces específicos, como ISBNs ou ISSNs. São úteis para manter referências consistentes mesmo quando os recursos mudam de local.

---

### **Páginas Estáticas**
- **Conteúdo fixo**: Não muda dinamicamente, é pré-definido.
- **Funcionamento**: O navegador recebe exatamente o que está armazenado no servidor.
- **Tecnologias principais**: HTML, CSS e, opcionalmente, JavaScript simples.
- **Usos típicos**: Portfólios, sites institucionais, blogs simples.
- **Vantagens**: Simples, rápidas e de baixo custo.


### **Páginas Dinâmicas**
- **Conteúdo dinâmico**: Gera respostas personalizadas com base no usuário ou em dados em tempo real.
- **Funcionamento**: O servidor processa a requisição, acessa bancos de dados ou APIs, e retorna um conteúdo personalizado.
- **Tecnologias principais**: Linguagens de back-end (PHP, Python, etc.), APIs e bancos de dados.
- **Usos típicos**: Redes sociais, e-commerce, sistemas interativos.
- **Vantagens**: Interatividade, dados atualizados e experiências ricas.

### **Resumo das diferenças principais**:
- **Mudança de conteúdo**: Estática = fixo / Dinâmica = personalizado.
- **Complexidade**: Estática = simples / Dinâmica = exige integrações.
- **Interatividade**: Estática = limitada / Dinâmica = avançada.
­          
­­­­­­                        
---


### Servlets

**Servlets** são componentes Java usados para criar aplicações web dinâmicas. Eles processam requisições HTTP no lado do servidor e geram respostas adequadas, como HTML ou outros tipos de dados. Sua função principal é manipular a lógica de negócios, interagir com APIs, acessar bancos de dados e preparar os dados que serão enviados ao cliente.

`HTTP é o protocolo de comunicação utilizado na web para transferir informações entre cliente e servidor. Ele é baseado em texto e segue o modelo requisição/resposta. Uma requisição HTTP geralmente inclui um método (como GET ou POST), cabeçalhos e, em alguns casos, um corpo de dados.`

---

### JSP (JavaServer Pages)

**JSP** é uma tecnologia Java que facilita a criação de interfaces para aplicações web. É projetada para trabalhar com HTML, permitindo a inclusão de código Java diretamente na página, o que torna o desenvolvimento do front-end dinâmico mais intuitivo. JSP é amplamente utilizada para exibir informações processadas pelos Servlets.

---

### Relação entre Servlets e JSP

- **Cooperação entre Camadas**: Servlets lidam com a lógica de negócios e o processamento pesado no servidor, enquanto JSP se concentra na apresentação, ou seja, na interface exibida ao usuário.
- **Execução Interna**: Durante a execução, um arquivo JSP é compilado em um Servlet pelo servidor. Assim, ambos utilizam a mesma base tecnológica, mas têm responsabilidades distintas.
- **Divisão de Tarefas**: Servlets preparam os dados, enquanto JSP os renderiza de forma amigável e interativa para o cliente.
- **Ciclo de Desenvolvimento**: Juntos, Servlets e JSP ajudam a manter um design modular, separando o back-end (Servlets) do front-end (JSP), facilitando a manutenção e escalabilidade de aplicações.

Essa divisão de responsabilidades é essencial para criar aplicações web dinâmicas, eficientes e de fácil manutenção.

---