package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Launches the Spring Boot framework
        SpringApplication.run(Main.class, args);

        Demo demo=new DemoImpl();
        demo.print();
        demo.test();

        Demo.show();

        Demo d=()-> System.out.println("hi");
        d.test();





    }

}
