package com.hrg.service;


import com.hrg.entity.User;
import com.hrg.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {

    }

    @Override
    public User createNewUser(String email, String name, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return null;
        }
        else {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
            userRepository.save(user);
            return user;
        }
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User resetUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public User updateUserByEmail(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null) {
            user.setPassword(password);
            userRepository.save(user);
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
}