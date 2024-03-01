FROM openjdk:21-jdk-slim as build
COPY . .
RUN ./gradlew assemble

FROM openjdk:21-jdk-slim
COPY --from=build build/libs/*.jar app.jar
ARG PORT
ENV PORT $PORT
EXPOSE $PORT
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar","/app.jar"]
