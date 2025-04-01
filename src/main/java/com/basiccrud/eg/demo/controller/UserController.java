package com.basiccrud.eg.demo.controller;

import com.basiccrud.eg.demo.models.entity.User;
import com.basiccrud.eg.demo.models.response.BadRequestResponse;
import com.basiccrud.eg.demo.models.response.SuccessResponse;
import com.basiccrud.eg.demo.models.response.UserListResponse;
import com.basiccrud.eg.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.basiccrud.eg.demo.utils.Constants.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
   
    @Autowired
    private UserService userService;

    @ApiOperation(value = SWG_USER_LIST_OPERATION, response = SuccessResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = SWG_USER_LIST_MESSAGE, response = UserListResponse.class),
        @ApiResponse(code = 401, message = UNAUTHORIZED_MESSAGE, response = BadRequestResponse.class),
        @ApiResponse(code = 403, message = INVALID_DATA_MESSAGE, response = BadRequestResponse.class),
    })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

