<h1>Rest API Lanchonete</h1>
<hr>

<h2>O que foi utilizado:</h2>

<ul>Java 8</ul>
<ul>Spring Boot 2.1.4</ul>
<ul>Spring Security</ul>
<ul>JPA + Hibernate</ul>
<ul>H2 Database</ul>
<ul>Lombok</ul>
<ul>Maven</ul>

<h2>Rodando o Projeto</h2>

<p>O projeto está configurando com o tomcat embarcado. Não precisa necessidade de ter tomcat instalado. Somente o Java.</p>
<p>Na raiz do projeto, execute o comando ./mnvw clean package install. Isso irá gerar um build do projeto na pasta target</p>
<p>Depois, para iniciar o projeto, dentro da pasta target, utilize o comando: "java -jar lanchonete-api-0.0.1-SNAPSHOT.jar"
 

<p>A Base da API está na porta 8090</p>

http://localhost:8090/

<h2>Swagger - Documentação</h2>

<p>Documentação do swagger http://localhost:8090/swagger-ui.html</p>
<p>Recomendo utilizar o Postman ou Insomia para consumo de API.</p>

<h2>Segurança da API</h2>

<p>A API foi implementado a segurança Basic Auth com as seguintes permissões:</p>
<p> Usuário: admin </p>
<p> Senha: admin </p>


<h3> Banco de dados: </h3>

<p>O Projeto está com o banco de dados embarcado com H2, no tipo file.</p>
Para acessar, utilize as seguinte endereço:<br>

<p>http://localhost:8090/h2</p><br>

JDBC URL: jdbc:h2:file:./target/classes/db<br>
User Name:=sa<br>
Password:=<br>

<h3> Docker </h3>
<p>Com o docker instalado na máquina, execute o comando dentro da pasta do projeto:<p>

<p>docker build -t spring-app (Para buildar uma imagem docker);</p>
<p>docker run -p 8080:8090 spring-app (Para rodar a aplicação docker);</p>

Obs.: verifique a porta no server.port do application.properties para garantir a porta correta do Spring.


<h2> Futuro </h2>
<p>- Utilizar uma segurança mais sofisticada utilizando Oath2 e JWT e criações de usuários</p>
<p>- Por ser uma coisa bem específica, implementar as regras de segurança via banco de dados</p>