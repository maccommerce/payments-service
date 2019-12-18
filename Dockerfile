FROM openjdk:8-jre
MAINTAINER Wellington Costa <wellington.costa128@gmail.com>
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java", "-jar", "/payment-service.jar"]
