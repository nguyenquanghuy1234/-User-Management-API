package com.basiccrud.eg.demo.service;

import java.util.List;
import java.util.Optional;

import com.basiccrud.eg.demo.models.entity.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}