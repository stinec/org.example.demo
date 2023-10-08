package org.example.demo.repository;

import org.example.demo.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findByLastName(String lastName);
}
