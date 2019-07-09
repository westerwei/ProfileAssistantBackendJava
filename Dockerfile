# Derived from official OpenJDK 11.0.3 image (our base image)
FROM maven:3.6.1-jdk-11

LABEL description="OpenJDK-11 with Maven 3.6.1 and GIT for Profile Assistant AP"

MAINTAINER Wester Wei<wester.wei@gmail.com>

RUN mkdir pa-src && mkdir pa-src/src && mkdir pa-src/pa-app-logs
COPY pom.xml /pa-src/
COPY src /pa-src/src/
RUN cd pa-src && mvn package

RUN apt-get update \
    && apt-get install -y git

# ENTRYPOINT ["/bin/bash"]
# ENTRYPOINT ["java -jar /pa-src/target/profileassistant-backend-java-1.0-SNAPSHOT.jar >> /pa-src/pa-app-logs/pa-app-logger.all.log 2>&1 &"]
ENTRYPOINT ["java", "-jar", "/pa-src/target/profileassistant-backend-java-1.0-SNAPSHOT.jar", ">>", "/pa-src/pa-app-logs/pa-app-logger.all.log", "2>&1", "&"]

# CMD ["mvn","-v"]
