# HelloWorldServlet

## Descrição
Este projeto demonstra um exemplo básico de um **servlet** configurado usando o método tradicional, com mapeamento via **web.xml**. O servlet responde a requisições HTTP do tipo GET, gerando uma resposta HTML simples.

## Funcionalidades
- Responde a requisições HTTP GET.
- Exibe a mensagem "Hello World!" no navegador do cliente.
- Usa configuração tradicional no arquivo `web.xml` para mapear URLs.

## Estrutura do código
- `HelloWorldServlet`: A classe principal que estende `HttpServlet` e implementa o método `doGet`.
- `web.xml`: Arquivo de configuração onde o mapeamento do servlet é definido.

## Requisitos
- Java Development Kit (JDK) 8 ou superior.
- Apache Tomcat (ou qualquer servidor compatível com Java EE).

## Como executar
1. Configure o Tomcat no Eclipse ou outro ambiente de desenvolvimento.
2. Importe o projeto no Eclipse e certifique-se de que o arquivo `web.xml` está configurado corretamente.
3. Inicie o servidor e acesse `http://localhost:<porta>/helloWorld`.

## Observações
Este exemplo utiliza a abordagem clássica e é ideal para aprender como configurar servlets manualmente.
