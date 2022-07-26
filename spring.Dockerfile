From openjdk:8
ADD build/libs/UrlHashing-0.0.1-SNAPSHOT.jar UrlHashing.jar
EXPOSE 8080
CMD ["java","-jar","UrlHashing.jar"]