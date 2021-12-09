#
# Build stage
#
FROM maven:3.6.3-jdk-11-slim AS build

ARG REVDEBUG_COMPILER_VERSION_ARG=6.1.8-dev-4

ARG REVDEBUG_HOST_ARG=localhost \
 REVDEBUG_FORCE_TLS_ARG=false \
 REVDEBUG_OFF_ARG=false \
 SW_AGENT_VERSION=6.1.10 

ENV SW_AGENT_VERSION=$SW_AGENT_VERSION \
    REVDEBUG_COMPILER_VERSION=$REVDEBUG_COMPILER_VERSION_ARG \
    REVDEBUG_HOST=$REVDEBUG_HOST_ARG \
    REVDEBUG_FORCE_TLS=$REVDEBUG_FORCE_TLS_ARG \
    REVDEBUG_OFF=$REVDEBUG_OFF_ARG 



RUN apt-get update
RUN apt-get install -y wget
COPY src /home/app/src
COPY pom.xml /home/app
COPY .git /home/app/.git

# # Getting Java Agent from nexus repoistory 
RUN mkdir -p /home/app/agent \
&& wget -O /home/app/revdebug-agent.tar.gz https://nexus.revdebug.com/repository/files/agent/revdebug-agent-$SW_AGENT_VERSION.tar.gz \
&& tar -C /home/app/agent -xf /home/app/revdebug-agent.tar.gz

RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:11-jre-slim

ARG SW_AGENT_COLLECTOR_BACKEND_SERVICES_ARG=localhost:11800 \
     SW_AGENT_ACTIVE_ARG=1

ENV SW_AGENT_COLLECTOR_BACKEND_SERVICES=$SW_AGENT_COLLECTOR_BACKEND_SERVICES_ARG \
  SW_AGENT_ACTIVE=$SW_AGENT_ACTIVE_ARG

COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
COPY --from=build /home/app/agent /usr/local/lib/agent

# RUN echo agent.force_tls=$SW_AGENT_FORCE_TLS_ARG >> /usr/local/lib/agent/config/agent.config

CMD  if [ "$SW_AGENT_ACTIVE" = "1" ] ; then echo  apm ; java -javaagent:/usr/local/lib/agent/skywalking-agent.jar -jar /usr/local/lib/demo.jar ; else echo no apm $SW_AGENT_ACTIVE  ; java -jar /usr/local/lib/demo.jar ; fi
# CMD java -javaagent:/usr/local/lib/agent/skywalking-agent.jar -jar /usr/local/lib/demo.jar