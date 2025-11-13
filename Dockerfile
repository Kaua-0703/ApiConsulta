#maquina virtual
FROM maven:3.9.8-eclipse-temurin-21-jammy as builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

#rodar codigo

FROM eclipse-temurin-21-jammy

WORKDIR /app

COPY --from=builder /app/target/webapi-0.0.1.jar .

EXPOSE 8080

LABEL authors="Kauã"

ENTRYPOINT ["java", "-jar", "webapi-0.0.1.jar"]