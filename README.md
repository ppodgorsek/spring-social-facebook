# Spring Social Facebook

## What is it?

This project contains the module allowing Spring Social to interact with Facebook.

The versioning of this project follows the one of the Facebook API.

## Building the project

To check out the project and build from source, do the following:

  ```
    git clone git://github.com/SpringSource/spring-social-facebook.git
    cd spring-social-facebook
    ./gradlew build
  ```

## Development

### Eclipse

To generate Eclipse metadata (.classpath and .project files), do the following:

  ```
    ./gradlew eclipse
  ```

Once complete, you may then import the projects into Eclipse as usual:

  ```
    File -> Import -> Existing projects into workspace
  ```

### IDEA

To generate IDEA metadata (.iml and .ipr files), do the following:

  ```
    ./gradlew idea
  ```

### JavaDoc

To build the JavaDoc, do the following from within the root directory:

  ```
    ./gradlew :docs:api
  ```

The result will be available in 'docs/build/api'.

## Please contribute!

Have you found an issue? Do you have an idea for an improvement? Feel free to contribute by submitting it [on the GitHub project](https://github.com/ppodgorsek/spring-social-facebook/issues).
