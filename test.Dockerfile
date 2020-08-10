FROM openjdk:12
RUN mkdir /usr/dev/
COPY /target/demo-1.0.jar /usr/dev/
WORKDIR /usr/dev/
EXPOSE 80 80
CMD ["java", "-jar", "-Dspring.profiles.active=test", "demo-1.0.jar"]