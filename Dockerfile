# Imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o container
COPY target/flyflix-0.0.1-SNAPSHOT.jar app.jar

# Porta que a aplicação vai rodar
EXPOSE 8080

# Rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
