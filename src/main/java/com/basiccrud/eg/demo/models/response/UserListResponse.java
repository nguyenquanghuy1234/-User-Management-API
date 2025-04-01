package com.basiccrud.eg.demo.models.response;

import java.util.List;
import com.basiccrud.eg.demo.models.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class UserListResponse {
    private List<User> data;
}