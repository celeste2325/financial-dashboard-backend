FROM ubuntu:22.04
RUN apt-get update && apt-get install -y openjdk-17-jdk
VOLUME /tmp
COPY target/financial-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]