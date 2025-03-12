FROM maven:3.9.9-amazoncorretto-21-al2023 as build #pega a imagem do maven
WORKDIR /app #Define o diretorio app
COPY . . /copia tudo nao sei da onte
RUN mvn clean package -DskipTests //roda o mvn clean package para gerar o jar

FROM openjdk:21 #pega a imagem do java 21
WORKDIR /app #Define diretorio app
COPY --from=build /app/target/*.jar ./app.jar #pega o .jar do build e joga no diretorio app
EXPOSE 8761 #Expõe porta 8761
ENTRYPOINT java -jar app.jar # execute a aplicação java