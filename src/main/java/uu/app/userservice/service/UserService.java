package uu.app.userservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uu.app.userservice.model.UserEntity;
import uu.app.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserEntity createUser(UserEntity user) {
        return repository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return repository.findById(id);
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        return repository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return repository.save(user);
        }).orElse(null);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
