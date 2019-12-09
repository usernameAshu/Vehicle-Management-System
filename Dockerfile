FROM openjdk:8
EXPOSE 8081
ADD target/VMSVersion1.jar VMSVersion1.jar
ENTRYPOINT ["java", "-jar" ,"/VMSVersion1.jar"] 