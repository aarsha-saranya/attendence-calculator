FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/AttendanceCalculator-1.0.jar app.jar

EXPOSE 2020

ENTRYPOINT ["java", "-jar", "app.jar"]