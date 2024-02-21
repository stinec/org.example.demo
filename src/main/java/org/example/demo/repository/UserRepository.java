package org.example.demo.repository;

import org.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByLastNameContaining(String lastName);

    List<User> findByFirstNameContaining(String firstName);

    List<User> findBySex(String sex);

    List<User> findByEmail(String email);

    User findByNickName(String nickName);

    Optional<User> findById(Integer id);
}
