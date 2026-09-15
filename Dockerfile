FROM maven:3.9-eclipse-temurin-21

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:resolve

COPY . .
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/seu-app.jar"]