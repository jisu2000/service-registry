FROM maven:3.8.3-openjdk-17 AS buildCOPY . .RUN mvn clean installFROM eclipse-temurin:17-jdkCOPY --from=build /target/service-registry.jar demo.jarEXPOSE 8000ENTRYPOINT ["java", "-jar", "demo.jar"]