FROM openjdk:11-jre-slim
VOLUME /tmp
MAINTAINER montalvo.com
ADD target/bank-0.0.1-SNAPSHOT.jar bank-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bank-0.0.1-SNAPSHOT.jar"]