FROM tomcat:9.0
MAINTAINER Spurthi

# fixed path for copying
RUN /bin/bash -c "rm -rf /usr/local/tomcat/webapps"
RUN /bin/bash -c "mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps"
ADD ./target/SWE645-HW3.war /usr/local/tomcat/webapps/

# Routine for me - optional for your case
EXPOSE 8080

# And run tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
