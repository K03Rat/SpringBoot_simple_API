package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            Student kristian = new Student(
                    1L,
                    "Kristian",
                    LocalDate.of(2003, Month.APRIL, 28),
                    "kristianratnikov28@gmail.com"
            );
            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2005, Month.MARCH, 22),
                    "alex@gmail.com"
            );

            repository.saveAll(List.of(kristian, alex));
        };
    }
}
