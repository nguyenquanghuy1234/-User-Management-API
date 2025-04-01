package com.basiccrud.eg.demo.service;

import com.basiccrud.eg.demo.models.entity.User;
import com.basiccrud.eg.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(userDetails.getUserName());
            user.setUserEmail(userDetails.getUserEmail());
            user.setUserAddress(userDetails.getUserAddress());
            user.setUserPhoneNumber(userDetails.getUserPhoneNumber());
            user.setUserAvatar(userDetails.getUserAvatar());
            user.setUserDateOfBirth(userDetails.getUserDateOfBirth());
            user.setUserGender(userDetails.getUserGender());
            user.setUserRole(userDetails.getUserRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
