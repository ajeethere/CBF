package com.cbf.cbf.controllers;


import com.cbf.cbf.entities.User;
import com.cbf.cbf.services.UserService;
import com.cbf.cbf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setCreatedAt(Utils.getDate());
        user.setUpdatedAt(Utils.getDate());
        Optional<User> user1 = userService.getUserByNumber(user.getNumber());
        if (user1.isPresent()) {
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getUserByNumber(@PathVariable String number) {
        return ResponseEntity.ok(userService.getUserByNumber(number));
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("deleted");
    }
}
