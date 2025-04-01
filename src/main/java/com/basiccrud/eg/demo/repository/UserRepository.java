package com.basiccrud.eg.demo.repository;

import org.springframework.stereotype.Repository;

import com.basiccrud.eg.demo.models.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName); // Sửa từ findByUsername thành findByUserName
}