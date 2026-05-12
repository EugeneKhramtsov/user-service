package uu.app.userservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uu.app.userservice.model.UserEntity;
import uu.app.userservice.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        log.info("Create User {}", user);
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        log.info("Get All Users");
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        log.info("Get User by id {}", id);
        return service.getUserById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        log.info("Update User {}", user);
        return Optional.ofNullable(service.updateUser(id, user)).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Delete User by id {}", id);
        service.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
