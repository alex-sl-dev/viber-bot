FROM openjdk:8
ADD target/Realm2Bot.jar Realm2Bot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Realm2Bot.jar"]
