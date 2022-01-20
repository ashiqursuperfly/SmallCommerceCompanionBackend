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

#### Mongo Query Guide
```
@Query("{'author' : ?0, 'category' : ?1}")
List<Book> findPositionalParameters(String author, String category);

@Query("{'author' : :#{#author}, 'category' : :#{#category}}")
List<Book> findNamedParameters(@Param("author") String author, @Param("category") String category);
```
In the first approach, the first positional argument, ?0, corresponds to the first argument in the method, and the value of the argument will be used instead of ?0. This means that you have to keep track of the positions and not mix them up, otherwise, MongoDB will silently fail and just won't return the results, given the schema-flexibility, since you might as well have that property.


#### TODO:
- Standard way to handle post/put responses. Since, Spring Repository .save() method does not return what the exact value of the data looks like after saving in the database.
Possible Solution: 1) Strip out null values. But, it wont solve the issue when user enters some useless data in the requestbody. 2) Fetch again after save and return (db RT increases, so not good). 3) No response at all. But, need response to know the id generated for the autogenerated sequence (and business secret)

- Generate Swagger

- Force Https