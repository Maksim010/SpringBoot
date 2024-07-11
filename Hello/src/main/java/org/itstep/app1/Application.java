package org.itstep.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController//1
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }



  //  @RestController//2
    static class Controller{

    }
}
