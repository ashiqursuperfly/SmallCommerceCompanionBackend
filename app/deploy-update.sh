./gradlew clean
./gradlew bootJar
cp build/libs/*.jar /home/ashiq/Documents/Workspaces/Spring-Workspace/SmallCommerceCompanionHeroku/heroku-remote/scom2b/app.jar
cd /home/ashiq/Documents/Workspaces/Spring-Workspace/SmallCommerceCompanionHeroku/heroku-remote/scom2b
bash deploy.sh