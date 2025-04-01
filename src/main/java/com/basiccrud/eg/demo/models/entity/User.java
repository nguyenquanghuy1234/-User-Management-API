package com.basiccrud.eg.demo.models.entity;

import java.time.LocalDate;

import com.basiccrud.eg.demo.models.entity.Common.BaseEntity;
import com.basiccrud.eg.demo.models.entity.Common.Gender;
import com.basiccrud.eg.demo.models.entity.Common.UserRole;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(unique = true, nullable = false) 
    private String userName;
    
    private String userAddress;

    @Column(unique = true, nullable = false)
    private String userEmail;

    private String userPhoneNumber;
    private String userAvatar;
    private LocalDate userDateOfBirth;

    @Enumerated(EnumType.STRING) // Lưu Enum dưới dạng chuỗi
    private Gender userGender;

    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
