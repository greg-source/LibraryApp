package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.User;
import com.library.LibraryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody User user) {
        return ResponseEntity.ok(userService.insert(user));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }
}
