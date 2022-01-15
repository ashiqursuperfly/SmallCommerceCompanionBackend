#### Small Commerce Companion

#### Spring Boot Gradle Commands
##### Run The Project
```shell
bash gradlew bootRun
```
##### List of Commands
```shell
bash gradlew tasks
```
#### Automatic Dependency Injection
##### Enabling @Autowired
- Spring Boot introduces the `@SpringBootApplication` annotation.
- This single annotation is equivalent to using `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- As a result, when we run an application annotated with @SpringBootApplication, it will automatically scan the components in the current package and its sub-packages.
Thus it will register them in Spring's Application Context, and allow us to inject beans using @Autowired.
##### Using @Autowired
- After enabling annotation injection, we can use autowiring on properties, setters, and constructors.

