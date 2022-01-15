FROM openjdk:16

COPY build/libs/*.jar learn-english-words-bot-0.0.3.jar

ENTRYPOINT java -Dfile.encoding=UTF-8 -jar learn-english-words-bot-0.0.3.jar
EXPOSE 8080