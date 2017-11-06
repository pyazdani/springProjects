package com.pyazdani.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// 1. Annotation
@RestController
public class StringsApplication {

        public static void main(String[] args) {
                SpringApplication.run(StringsApplication.class, args);
        }
        
        // 1. Annotation
        @RequestMapping("/")
        // 3. Method that maps to the request route above
        public String welcome() { // 3
                return "Welcome to The Strings!!!";
        }
        
        @RequestMapping("/random")
        
        public String springBoot() {
        			return "This is a nice and pleasant message about Spring Boot.";
        }
}