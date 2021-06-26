# learn_spring_batch

# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#howto-batch-applications)

## Guides
The following guides illustrate how to use some features concretely:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


###Arguments with run project
-stepName=HelloStep -arquivoClientes=file:files/clientes.txt

###Properties file
run in root of project mkdir ..\config\learn_spring_batch\application.properties

with content personal:
###BD Primary
```
spring.datasource.jdbcUrl=jdbc:mysql://localhost:3306/name_your_bd?useUnicode=true
spring.datasource.username=you_user
spring.datasource.password=you_password
spring.batch.jdbc.initialize-schema=always
```
###BD Secondary
```
app.datasource.jdbcUrl=jdbc:mysql://localhost:3306/app?useUnicode=true
app.datasource.username=you_user_app
app.datasource.password=you_app_password
app.batch.jdbc.initialize-schema=always
```