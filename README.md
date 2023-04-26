# Gerenciador servlet tomcat 9.0
FROM tomcat:9.0
MAINTAINER Leonardo Mattana
COPY ./target/gerenciador-servlet-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
 
