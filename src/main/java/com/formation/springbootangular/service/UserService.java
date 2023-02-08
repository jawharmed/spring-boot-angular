package com.formation.springbootangular.service;

import com.formation.springbootangular.entity.User;
import com.formation.springbootangular.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user) throws Exception{
        userRepository.findById(user.getId()).orElseThrow(Exception::new);

        return userRepository.save(user);
    }

}
