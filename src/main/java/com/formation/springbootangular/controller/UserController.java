package com.formation.springbootangular.controller;

import com.formation.springbootangular.entity.User;
import com.formation.springbootangular.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/byLogin/{login}")
    public User getUserByLogin(@PathVariable String login) throws Exception {
        if(login.isEmpty()){
            throw new Exception("Login est null!");
        }
        return userService.getUserByLogin(login);
    }

    @PostMapping
    public User createUser(@RequestBody User user){

        return userService.createUser(user);
    }

}
