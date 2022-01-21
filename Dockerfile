FROM tomcat:9-jdk11-openjdk

RUN apt-get update
RUN apt-get upgrade

WORKDIR app
COPY ./*.jar app.jar

RUN useradd user
RUN chown -R user:user .
# chmod 755 means read and execute access to the user and write access to the owner
RUN chown -R user:user .
RUN chmod -R 755 .

# switch to our user
USER user


ENTRYPOINT [ "java","-jar","app.jar" ]
#ENTRYPOINT ["tail", "-f", "/dev/null"]