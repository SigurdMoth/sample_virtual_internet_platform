FROM ubuntu:latest
COPY * .

EXPOSE 50003
RUN chmod -x ./gradlew
RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
CMD ./gradlew bootRun