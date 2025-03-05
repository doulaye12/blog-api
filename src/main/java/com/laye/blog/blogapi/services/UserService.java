package com.laye.blog.blogapi.services;

import com.laye.blog.blogapi.models.User;
import com.laye.blog.blogapi.repositories.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    // Récupérer un utilisateur par son username
    public Optional<User> getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // Ajouter un nouvel utilisateur
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Supprimer un utilisateur
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User deleted";
    }
}
