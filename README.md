<p align="left"><img src="https://github.com/gustavottc/CRUD-Java/blob/master/logo.png" width="250" height="250"></p>

# CRUD-JAVA-WEB
CRUD/CIDA com Java utilizando o gerenciador de depend�ncias Apache Maven 

- Java Web
- Maven
- JSP
- SQL
- JDBC
- JUnit
- Materialize

## Como usar: 
### Windows, Linux e MacOS
Primeiros passos
### Aquisi��o da IDE e do Servidor
- Baixe o [Java 8](https://www.java.com/pt_BR/download/).
- Baixe o [Eclipse IDE](https://www.eclipse.org/downloads/).
- Baixe o [Tomcat 8.5](https://tomcat.apache.org/download-80.cgi).
- Baixe o SQL (Voc� pode baixar o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/), ou qualquer outro servi�o SQL).
- Baixe o [reposit�rio](https://github.com/gustavottc/CRUD-JAVA-WEB/archive/master.zip) da aplica��o.
### Configura��o e instala��o
- Java
  - Instala��o:
    - Instale a aplica��o normalmente
  - Configura��o:
    - N�o ha necessidade
- Eclipse
  - Instala��o:
    - Instale a aplica��o normalmente
  - Configura��o:
    - Com o Eclipse iniciado, v� em:
      - "File"
        - "Open Projects from File System"
          - Selecione o diret�rio que voc� baixou o reposit�rio da aplica��o e clique em "finish".
    - Clique no bot�o direito na pasta do projeto
      - V� em "Servers" (se encontra na parte inferior do programa, caso n�o tenha encontrado, procure por ele em "Quick Acess")
        - Clique para adicionar um novo servidor
          - Selecione "Tomcat v8.5 Server" e clique em Next
            - Selecione a pasta em que voc� baixou o "Tomcat 8.5"
            - Selecione o JRE como: jre_1.8.0_xxx e clique em "Finish"
- SQL
  - Instala��o:
    - Instale a aplica��o normalmente
  - Configura��o:
    - Configure a porta do SQL como padr�o (3306)
    
### Uso da aplica��o
Com o Eclipse rodando e o projeto selecionado, espere que o Maven baixe todas as depend�ncias do projeto, logo ap�s, verifique se o SQL est� rodando na porta 3306
- Baixe e execute o Script SQL: [crud_java.sql](https://github.com/gustavottc/CRUD-Java/blob/master/crud_java.sql)
- Clique com o bot�o direito em cima do nome do projeto e clique em:
  - "Run As"
    - "Run on Server"
      - Selecione o "Tomcat v8.5 Server at localhost" e clique em "Finish"