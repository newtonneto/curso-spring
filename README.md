# CURSO SPRING

## Instruções para iniciar o banco de dados com docker

- ### MySQL

  Pré-requisitos:
    * [Docker](https://docs.docker.com/get-docker/)

  Com o seu terminal aberto e dentro do diretório do projeto, insira os seguintes comandos:
  ```sh 
    $ docker pull mysql:latest
  ```
  ```sh 
    $ docker run -p 3307:3306 --name mysql_curso_spring -e MYSQL_ROOT_PASSWORD=senha -d mysql:latest
  ```
  ```sh 
    $ docker pull phpmyadmin/phpmyadmin:latest
  ```
  ```sh 
    $ docker run --name phpMyAdmin_curso_spring -d --link mysql_curso_spring:db -p 8081:80 phpmyadmin/phpmyadmin
  ```

  Para acessar o phpMyAdmin acesse a URL *http://localhost:8081/* e entre com as credenciais root/senha

- ### PostgreSQL

  Pré-requisitos:
    * [Docker](https://docs.docker.com/get-docker/)

  Com o seu terminal aberto e dentro do diretório do projeto, insira os seguintes comandos:
  ```sh 
    $ docker pull postgres:latest
  ```
  ```sh 
    $ docker pull dpage/pgadmin4
  ```
  ```sh 
    $ docker network create --driver bridge postgres-network
  ```
  ```sh 
    $ docker run --name postgres_spring --network=postgres-network -e POSTGRES_PASSWORD=senha -p 5432:5432 -d postgres
  ```
  ```sh 
    $ docker run --name pgadmin_spring --network=postgres-network -p 15432:80 -e PGADMIN_DEFAULT_EMAIL=seu_email@email.com -e PGADMIN_DEFAULT_PASSWORD=senha -d dpage/pgadmin4
  ```
  
  Para acessar o pgAdmin4 acesse a URL *http://localhost:15432* e entre com as credenciais seu_email@email.com/senha

Na raiz do projeto se encontra dois arquivos .sql, um para o PostgreSQL e outro para o MySQL, os mesmos devem ser importados para o respectivo banco de escolha do usuário. Por padrão o projeto está configurado para utilizar o PostgreSQL, caso deseje utilizar o MySQL, a configuração do application-dev.properties deve ser alterada.

## Amazon S3

  É necessário incluir no arquivo application.properties a chave de acesso e a chave de acesso secreta para rodar o projeto

