./gradlew clean
./gradlew bootJar
cp build/libs/*.jar ../heroku/heroku-remote/app.jar
cd ../heroku/heroku-remote
bash deploy.sh