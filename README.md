<h1>Rest API Lanchonete</h1>
<hr>

<h2>Tecnologias</h2>
<hr>

<ul>Java 8</ul>
<ul>Spring Boot 2.1.4</ul>
<ul>H2 Database</ul>
<ul>Hibernate</ul>
<ul>Sprig Data JPA</ul>
<ul>Lombok</ul>
<ul>Maven</ul>

<h2>Rodando o Projeto</h2>
<hr>

A Base da API está na porta 8090
http://localhost:8090/

<h3> Banco de dados: </h3>
<hr>
O Projeto está com o banco de dados embarcado com H2, no tipo file.<br> 
Para acessar, utilize as seguinte endereço:<br>

http://localhost:8090/h2<br><br>

JDBC URL: jdbc:h2:file:./target/classes/db<br>
User Name:=sa<br>
Password:=<br>


<h2>Swagger - Documentação</h2>
<hr>
Documentação do swagger http://localhost:8090/swagger-ui.html<br>
Recomendo utilizar o Postman ou Insomia para consumo de API.<br><br>

<h3> Docker </h3>
<hr>
Com o docker instalado na máquina, execute o comando dentro da pasta do projeto:

docker build -t spring-app (Para buildar uma imagem docker);
docker run -p 8080:8090 spring-app (Para rodar a aplicação docker);

Obs.: verifique a porta no server.port do application.properties para garantir a porta correta do Spring.


<h2> Futuro </h2>
<hr>