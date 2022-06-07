FROM openjdk:17.0.2

WORKDIR /opt/

COPY /target/beauty-salon-1.0.0.jar ./beauty-salon-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/beauty-salon-1.0.0.jar"]