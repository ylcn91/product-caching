package com.doksanbir.productcaching.ui.controller;

import com.doksanbir.productcaching.model.dto.UserDtoPost;
import com.doksanbir.productcaching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserDtoPost userDtoPost) {
        userService.createUser(userDtoPost);

        return new ResponseEntity<>(userDtoPost,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getUser(@Valid @RequestParam String email){
        return new ResponseEntity<>(userService.getUser(email),HttpStatus.ACCEPTED);
    }

    @GetMapping("all")
    public ResponseEntity<?> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "limit", defaultValue = "2") int limit){
        return new ResponseEntity<>(userService.getUsers(page, limit),HttpStatus.ACCEPTED);
    }

}
