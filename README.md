#dius-bowling-game

## Packaging using Maven
Use the following commands to package the solution and make Jar file:

```
mvn package
```

## Running tests using Maven
Use the following command to test the solution:

```
mvn test
```

## Running using java
After packaging the solution, you can simply run it with java, passing the class path:

```
java -cp target/dius-bowling-1.jar au.com.dius.Driver
```

## Running using Docker
Firstly make the assembly jar (dius-bowling-1.jar) and then build the image using the following command:
```
docker build -t dius-bowling-game .
```

Then run the docker image:
```
docker run -it --rm  dius-bowling-game
```


