# Agenda de contatos
Um projeto simples de uma agenda de contatos feito Java Web,Jsp e Servlets.
## Funcionalidades:
- **Listar todos os Contatos**
- **Adicionar novo contato**
- **Excluir contato existente**
- **Editar contato existente**
## Tecnologias Usadas:
- JavaSE-22
- HTML 5
- Servlet
- JSP (JavaServer Pages)
- Apache Tomcat-10.1.24
- Mariadb-3.4.1
- JDBC
## Como usar ?:
1. Clone o repositório;
```markdown
https://github.com/JoaoPSCalazans/ProjetoServlet-JSP.git
```
3. Importe na sua IDE (ex:Eclips)
4. Configure o Tomcat
5. Crie o banco de dados:
 ```sql
  CREATE DATABASE agenda_de_contatos;
  USE agenda_de_contatos;
  CREATE TABLE contatos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    fone VARCHAR(20),
    email VARCHAR(100)
  );
 ```
5. Atualize o arquivo dao/ContatosDAO.java com seu usuário e senha do banco:
```java
 private final String user = "SEU_USUARIO";
private final String password = "SUA_SENHA";
```
