FROM ubuntu:latest
MAINTAINER cherrish
VOLUME /home/container
ADD cloud-eureka-1.0.0-SNAPSHOT.jar app.jar
ADD jdk8.tar.gz /usr/java/
ENV JAVA_HOME=/usr/java/jdk1.8.0_152
ENV JRE_HOME=/usr/java/jdk1.8.0_152/jre
ENV CLASSPATH=$JAVA_HOME/lib:$JAVA_HOME/jre/lib
ENV PATH=$JAVA_HOME/bin:$PATH
ENV LANG C.UTF-8
ENV TZ Asia/Shanghai
RUN bash -c 'touch /app.jar'
EXPOSE 10110
ENTRYPOINT ["java","-jar","app.jar"]
