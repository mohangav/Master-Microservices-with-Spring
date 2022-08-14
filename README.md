# Master-Microservices-with-Spring

create new repository using commond:
    echo "# <repositoryName>" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/mohangav/studygraph.git
    git push -u origin main
    
push existing from commond line
    git remote add origin https://github.com/mohangav/studygraph.git
    git branch -M main
    git push -u origin main
///

mvn clean install -Dmaven.test.skip=true / mvn -DskipTests=true clean compile

docker build . -t mohangavandeoutlook/accounts

mvn spring-boot:run

mvn spring-boot:build-image

docker-compose up

docker-compose down

docker image rm <imagename>

docker push docker.io/[image-name]
