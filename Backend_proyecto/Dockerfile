# Usa la imagen de OpenJDK 17 en Alpine como base
FROM openjdk:17-alpine

# Copia el archivo JAR del backend en la imagen de Docker
COPY target/Lucas-Ortega-0.0.1-SNAPSHOT.jar portfolio-app.jar

# Expone el puerto 8080 para que Render pueda enrutar el tráfico correctamente
EXPOSE 8080

# Establece el comando de inicio para la aplicación
CMD ["java", "-jar", "/portfolio-app.jar"]
