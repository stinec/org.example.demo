package org.example.demo.controller;

import org.example.demo.entity.City;
import org.example.demo.entity.User;
import org.example.demo.repository.CityRepository;
import org.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CityRepository cityRepo;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(
        @RequestParam(required = false) String email) {
        try {
            List<User> users = new ArrayList<User>();
            if (email == null)
                users.addAll(userRepo.findAll());

            if (email != null)
                users.addAll(userRepo.findByEmail(email));

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @GetMapping("/users/{nickName}")
    public ResponseEntity<User> getUserByNickName(@PathVariable("nickName") String nickName) {
        User userData = userRepo.findByNickName(nickName);

        if (userData != null) {
            return new ResponseEntity<User>(userData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/id{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            return new ResponseEntity<User>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Optional<City> cityData = cityRepo.findById(user.getCity().getId());
        if (user.getFollowings() != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            try {
                userRepo.save(user);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            user.setCity(cityData.get());
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
    }

//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id) {
//        Optional<User> userData = userRepo.findById(id);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setName(_user.getName());
//            _user.setEmail(_user.getEmail());
//            return new ResponseEntity<>(userRepo.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        try {
            userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
