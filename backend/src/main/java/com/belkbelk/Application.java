package com.belkbelk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/** Entry point
* How to run without depending on an IDE:
* 1) for simple run: mvn spring-boot:run
* 2) with debug: mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005" and then connect with debugger.
* In the second case after debugger is connected, the context will be initialized
*/

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
