# Usa una imagen base de Eclipse Temurin (JDK 17)
FROM eclipse-temurin:17.0.13_11-jdk

# Exponer el puerto que usará la aplicación
EXPOSE 8080

# Directorio de trabajo dentro del contenedor
WORKDIR /root

# Copiar el archivo pom.xml para descargar las dependencias
COPY ./pom.xml /root

# Copiar los archivos necesarios para el Maven Wrapper
COPY ./.mvn /root/.mvn
COPY ./mvnw /root/mvnw

# Asegurarse de que el wrapper tiene permisos de ejecución y descargar dependencias
RUN chmod +x ./mvnw && ./mvnw dependency:go-offline

# Copiar el código fuente del proyecto al contenedor
COPY ./src /root/src

# Construir el proyecto, omitiendo los tests
RUN ./mvnw clean install -DskipTests

# Comando para ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "/root/target/PruebaTecnica-0.0.1-SNAPSHOT.jar"]
