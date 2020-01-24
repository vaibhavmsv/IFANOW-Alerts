
# fetch basic image
FROM maven:3.5.2-jdk-8 as build

# application placed into /opt/app
WORKDIR /src/

# selectively add the POM file and
# install dependencies
COPY pom.xml .
COPY src src
# rest of the project
RUN mvn install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
WORKDIR /src/
VOLUME /tmp
ARG TARGET=/target/

COPY --from=build ${TARGET}/classes .


EXPOSE 8080
ENTRYPOINT ["java","-cp","/src:/src/lib/*","com.dekses.jersey.docker.demo.Main"]