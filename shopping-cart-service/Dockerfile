FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/shopping-cart-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8889

ENTRYPOINT ["java", "-jar", "app.jar"]