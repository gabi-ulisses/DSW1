# Usuario Servlet

## Descrição
Este projeto é um exemplo simples de um servlet Java chamado **`Usuario`**, que responde a requisições HTTP do tipo GET e POST. Ele é projetado para demonstrar a estrutura básica de um servlet utilizando a classe `HttpServlet`.

## Funcionalidades
- **Requisição GET**: Retorna uma mensagem simples com o caminho de contexto da aplicação.
- **Requisição POST**: Encaminha a requisição ao método GET, reutilizando sua lógica.

## Estrutura do Código
- **`Usuario`**: A classe principal que estende `HttpServlet`. 
  - Método `doGet`: Trata requisições HTTP do tipo GET.
  - Método `doPost`: Encaminha as requisições POST para serem tratadas como GET.

## Requisitos
- **Java Development Kit (JDK)**: Versão 8 ou superior.
- **Servidor de Aplicação**: Apache Tomcat (ou qualquer outro compatível com Java EE).

## Como Executar
1. Configure o Apache Tomcat no seu ambiente de desenvolvimento (como Eclipse ou IntelliJ).
2. Importe o projeto para o ambiente de desenvolvimento.
3. Certifique-se de que o servlet está mapeado corretamente:
   - Se usar anotações, adicione `@WebServlet` no código.
   - Se usar `web.xml`, configure o mapeamento lá.
4. Inicie o servidor e acesse a URL correspondente no navegador, como:
   ```
   http://localhost:<porta>/usuario
   ```

## Como Expandir
- Adicionar lógica para processar dados enviados pelo cliente (como nome ou email de um usuário).
- Criar métodos para manipular dados de usuários, como salvar, listar ou excluir informações.
- Integrar com um banco de dados para persistir informações.

## Observações
Este projeto é uma base inicial e pode ser estendido para implementar funcionalidades mais complexas, como APIs REST ou sistemas de gerenciamento de usuários.
