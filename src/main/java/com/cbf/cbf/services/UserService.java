package com.cbf.cbf.services;

import com.cbf.cbf.entities.User;
import com.cbf.cbf.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    @CachePut(value = "user", key = "#user.id")
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable(value = "user", key = "#id")
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByNumber(String number) {
        return userRepository.findByNumber(number);
    }

    @CacheEvict(value = "user",key = "#id")
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}