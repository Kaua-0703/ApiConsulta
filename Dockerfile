# ====== BUILD ======
FROM maven:3.9.8-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


# ====== RUN ======
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/target/webapi-0.0.1.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "webapi-0.0.1.jar"]
