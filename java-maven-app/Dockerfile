
FROM tomcat:9.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/myproject.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
