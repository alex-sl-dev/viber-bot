FROM openjdk:8
ADD target/viber-bot-0.0.1-SNAPSHOT.jar viber-bot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","viber-bot-0.0.1-SNAPSHOT.jar"]
