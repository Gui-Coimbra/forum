FROM adoptopenjdk/openjdk16
EXPOSE 8080
# Adiciono o .jar do projeto e o apelido de forum.jar
ADD /target/forum-0.0.1-SNAPSHOT.jar forum.jar
# A tag XX:+UseContainerSupport notifica a JVM que a aplicação rodará em uma JVM de em um container
# -Xnx300m -Xss512k Inidica o máximo e mínimo de memória utilizada pela apicação
# -XX:CICompilerCount=2 Seleciona os compiladores (detalhes da jvm)
# -Dserver.port=$PORT Quem seleciona a porta em tempo de execução é o Heroku, portanto indicamos a porta como uma variável
# -Dspring.profiles.active=prod seta o profile de prod
ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=prod", "-jar", "forum.jar"]
