package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(Application.class, args);
        System.out.println(Pig.pig);
    }
}
