# TarefaServletDemo

## Descrição
Este projeto é uma demonstração de um servlet Java chamado **`TarefaServletDemo`**, que utiliza a anotação `@WebServlet` para mapear a URL `/hello`. Ele processa requisições HTTP do tipo GET e POST, capturando dados do cliente e exibindo respostas dinâmicas em HTML no navegador.

## Funcionalidades
- **Requisição GET**:
  - Obtém os parâmetros `nome` e `idade` enviados na URL.
  - Calcula o dobro da idade fornecida e exibe o nome e a idade calculada no navegador.

- **Requisição POST**:
  - Processa dados enviados pelo cliente, como o `nome`, `descricao` e múltiplos valores no parâmetro `periodo`.
  - Exibe os valores processados no console e no navegador.

## Estrutura do Código
- **TarefaServletDemo**:
  - Classe que estende `HttpServlet` para tratar requisições HTTP.
  - Método `doGet`: Processa parâmetros `nome` e `idade` e exibe os resultados no navegador.
  - Método `doPost`: Processa informações de tarefa (`nome`, `descricao`, `periodo`) e gera uma resposta HTML.

## Requisitos
- **Java Development Kit (JDK)**: Versão 8 ou superior.
- **Servidor de Aplicação**: Apache Tomcat (ou qualquer outro compatível com Java EE).
- **Navegador**: Qualquer navegador moderno para acessar o servlet.

## Estrutura de Pastas
- **Pacote principal**: `br.edu.ifsp.arq`
- **Localização do servlet**: Dentro do pacote `br.edu.ifsp.arq`.

## Como Executar
1. Configure o Apache Tomcat ou outro servidor compatível no seu ambiente de desenvolvimento.
2. Importe o projeto e compile a aplicação.
3. Acesse a URL correspondente no navegador:
   - Para requisições GET: `http://<servidor>/hello?nome=SeuNome&idade=30`.
   - Para requisições POST: Envie parâmetros como `nome`, `descricao`, e múltiplos `periodo` via formulário HTML ou ferramenta como Postman.
4. Confira a resposta gerada no navegador e o console do servidor.

## Exemplos
### GET:
- URL: `http://localhost:8080/hello?nome=Ana&idade=25`
- Resposta:
  ```html
  <h1>Hello World, de novo!</h1>
  <p>Nome: Ana</p>
  <p>Idade: 50</p>
  ```

### POST:
- Dados enviados:
  - `nome=Estudo`
  - `descricao=Revisar conceitos`
  - `periodo=semanal,diario`
- Resposta no navegador:
  ```html
  <h1>Tarefa cadastrada com sucesso!</h1>
  <p>Nome: Estudo</p>
  <p>Descrição: Revisar conceitos</p>
  <p>Períodos: semanal diario </p>
  ```

## Observações
- Este projeto utiliza a anotação `@WebServlet` para simplificar o mapeamento de URLs.
- Considere usar arquivos CSS externos para melhorar a estilização das páginas HTML geradas.
- Ideal para aprender conceitos básicos de servlets e manipulação de requisições HTTP.

