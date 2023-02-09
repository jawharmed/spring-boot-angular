package com.formation.springbootangular.controller;

import com.formation.springbootangular.entity.User;
import com.formation.springbootangular.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
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

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        User createdUser = userService.updateUser(user);
        return ResponseEntity.ok(createdUser);
    }


    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }



}
