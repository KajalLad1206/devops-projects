FROM maven:3.8.6-openjdk-11 as builder 
WORKDIR /app
COPY . /app
RUN mvn clean package

FROM tomcat:9.0
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=builder /app/target/myproject.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
