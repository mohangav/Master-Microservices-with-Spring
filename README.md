# Master-Microservices-with-Spring

mvn clean install -Dmaven.test.skip=true / mvn -DskipTests=true clean compile

docker build . -t mohangavandeoutlook/accounts

mvn spring-boot:run

mvn spring-boot:build-image

docker-compose up

docker-compose down

docker image rm <imagename>
