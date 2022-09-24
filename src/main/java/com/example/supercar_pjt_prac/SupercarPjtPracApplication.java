package com.example.supercar_pjt_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SupercarPjtPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupercarPjtPracApplication.class, args);
    }

}
