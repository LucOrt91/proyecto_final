# Usa la imagen de Amazon Corretto 17 como base
FROM amazoncorretto:17-alpine-jdk

# Copia el archivo JAR del backend en la imagen de Docker
COPY Backend_proyecto/target/Lucas-Ortega-0.0.1-SNAPSHOT.jar portfolio-app.jar

# Copia el archivo system.properties en la imagen de Docker
COPY system.properties system.properties

# Expone el puerto 8080 para que Render pueda enrutar el tráfico correctamente
EXPOSE 8080

# Establece las variables de entorno necesarias para la aplicación
ENV JAVA_TOOL_OPTIONS="-Djava.runtime.version=17"

# Establece el comando de inicio para la aplicación
ENTRYPOINT ["java", "-jar", "/portfolio-app.jar"]
