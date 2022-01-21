./gradlew clean
./gradlew bootJar
cp build/libs/*.jar ../heroku/heroku-remote/app.jar
bash ../heroku/heroku-remote/deploy.sh