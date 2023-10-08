package org.example.demo;

import org.example.demo.entity.Users;
import org.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demoJpa(UserRepository repository) {
        return (args) -> {
            Users user1 = new Users("Vasya", "Petrov");
            Users user2 = new Users("Petya", "Ivanov");

            /* Добавление сущностей в БД */
            repository.save(user1);
            repository.save(user2);

            /* Мягкое удаление сущности из БД */
            repository.deleteById(1L);

            for (Users user : repository.findAll()) {
                System.out.println(user);
            }
        };
    }
}
