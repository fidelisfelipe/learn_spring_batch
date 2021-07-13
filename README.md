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

```java
-stepName=HelloStep 
-fileWidthFixed=file:files/file_width_fixed.txt 
-fileDelimitedComma=file:files/file_delimited_comma.txt 
-fileMultipleFormats=file:files/file_multi_format_part1.txt 
-fileListMultipleFormats=file:files/file_multi_format*.txt 
-fileXml=file:files/file.xml -fileJson=file:files/file.json 
-fileOut=file:files/write/file_width_fixed.txt 
-fileOutTwo=file:files/write/file_width_fixed_two.txt

```

###Properties files
create in folder for config external

> mkdir ..\config\learn_spring_batch

>add config\learn_spring_batch\application.properties

>add config\learn_spring_batch\log4j.xml

#With content personal in application.properties:

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



