FROM openjdk:8-jdk-alpine
EXPOSE 8098
ADD build/libs/SpringBoot-master-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]