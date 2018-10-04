# desafio-uol
API rest para cadastro de clientes, bem como cadastro de temperatura do local da requisição consumindo outras apis.


### Tecnologias Utilizadas

1. Java 8
2. Spring Boot 2

### Ambiente necessário para execução 

1. [JDK 8]
2. [Maven 3]

### Comando para executar

1. `cd {desafio-uol}`
2. `mvn spring-boot:run`
3. Acessar `http://localhost:8085`

### Gerar o pacate para publicação

1. `cd {desafio-uol}`
2. `mvn package`
3. `cd ./target`
4. `java -jar ${artifactId}.jar`

### Acessar a aplicação

A aplicação será disponibilizada na porta padrão 8085 [http://{host}:8085/](http://localhost:8085/)