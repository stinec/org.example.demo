package org.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner demoJpa(StudentRepository repository) {
//        return (args) -> {
//            Users user1 = new Users("Vasya", "Petrov");
//            Users user2 = new Users("Petya", "Ivanov");
//
//            /* Добавление сущностей в БД */
//            repository.save(user1);
//            repository.save(user2);
//
//            /* Мягкое удаление сущности из БД */
//            repository.deleteById(1L);
//
//            for (Users user : repository.findAll()) {
//                System.out.println(user);
//            }
//        };
//    }
}
