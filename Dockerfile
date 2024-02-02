FROM adoptopenjdk/openjdk16
EXPOSE 8080
# Adiciono o .jar do projeto e o apelido de forum.jar
ADD /target/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "-jar", "forum.jar"]