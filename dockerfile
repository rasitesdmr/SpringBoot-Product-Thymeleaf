FROM openjdk:17
EXPOSE 5555
ADD target/SpringBoot-Product-Thymeleaf-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]