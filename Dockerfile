# ==================== ETAPA 1: COMPILACIÓN ====================

# Imagen con Maven 3.9.9 y Java 17 para compilar el proyecto.
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Directorio de trabajo dentro de la imagen.
WORKDIR /app

# Copia el pom.xml del proyecto.
COPY pom.xml .

# Copia el código fuente.
COPY src ./src

# Compila el proyecto y genera el JAR.
RUN mvn clean package -DskipTests


# ==================== ETAPA 2: EJECUCIÓN ====================

# Imagen más ligera con Java 17 solo para ejecutar la aplicación.
FROM eclipse-temurin:17-jre

# Directorio de trabajo de la imagen final.
WORKDIR /app

# Copia el JAR generado en la etapa de compilación
# y lo renombra como app.jar.
COPY --from=build /app/target/*.jar app.jar

# Documenta que notificacion-service escucha en el puerto 8004.
# EXPOSE no publica el puerto en Windows; solo indica el puerto
# utilizado internamente por el contenedor.
EXPOSE 8004

# Cuando arranca el contenedor ejecuta el microservicio Spring Boot.
ENTRYPOINT ["java", "-jar", "app.jar"]