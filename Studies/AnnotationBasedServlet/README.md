# HelloWorld2

## Descrição
Este projeto demonstra um exemplo de **servlet moderno**, que utiliza a anotação `@WebServlet` para simplificar o mapeamento de URLs. O servlet responde a requisições HTTP do tipo GET, gerando uma resposta HTML simples.

## Funcionalidades
- Responde a requisições HTTP GET.
- Exibe a mensagem "Hello World, de novo!" no navegador do cliente.
- Usa a anotação `@WebServlet` para mapeamento de URLs diretamente no código.

## Estrutura do código
- `HelloWorld2`: A classe principal que estende `HttpServlet` e implementa o método `doGet`.

## Requisitos
- Java Development Kit (JDK) 8 ou superior.
- Apache Tomcat (ou qualquer servidor compatível com Java EE).

## Como executar
1. Configure o Tomcat no Eclipse ou outro ambiente de desenvolvimento.
2. Importe o projeto no Eclipse e certifique-se de que a classe `HelloWorld2` contém a anotação `@WebServlet("/hello")`.
3. Inicie o servidor e acesse `http://localhost:<porta>/hello`.

## Observações
Este exemplo utiliza uma abordagem moderna com anotações e é ideal para aprender como simplificar o mapeamento de servlets.
