FROM --platform=linux/x86_64 eclipse-temurin:17-jre-alpine
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/helloworld-0.0.1-SNAPSHOT.jar helloworld.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar helloworld.jar
