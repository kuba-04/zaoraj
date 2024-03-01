FROM eclipse-temurin:17 as build
COPY . .
RUN ./gradlew assemble

FROM eclipse-temurin:17
COPY --from=build build/libs/zaoraj-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/app.jar"]
