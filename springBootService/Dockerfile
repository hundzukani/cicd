#FROM hundzukani/openjdk8_alpine
FROM amazoncorretto
LABEL maintainer=hundzukanim@easyquotesolutions.co.za

ARG APP=springBootService
ADD ./target/$APP.jar app.jar

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "app.jar"]

