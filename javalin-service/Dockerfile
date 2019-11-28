FROM rbygrave/java11-base

USER app:app

WORKDIR /app
ADD target/lib /app/lib
ADD target/app.jar /app/app.jar

RUN mkdir -p /tmp/metrics
VOLUME /tmp/metrics

# For local docker build
#COPY application.yml /app/application.yml
#EXPOSE 8090

ENV JAVA_OPTS="-Dhello=me"

ENTRYPOINT /sbin/tini -- java ${JAVA_OPTS} -jar app.jar

