FROM tomcat:9-jdk11-openjdk
RUN apt-get update
COPY . /app

RUN useradd user
RUN chown -R user:user .
# chmod 755 means read and execute access to the user and write access to the owner
RUN chown -R user:user /app
RUN chmod -R 755 /app
# switch to our user
USER user


ENTRYPOINT [ "java","-jar","/app/build/libs/SmallCommerceCompanion-0.0.1-SNAPSHOT.jar" ]