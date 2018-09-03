package com.hrg.service;

import com.hrg.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createNewUser(String email, String name, String password);

    public User getUserByEmailAndPassword(String email, String password);

    public User updateUserByEmail(String email, String password);

    public User resetUserByEmail(String email);

    public List<User> getAllUsers();

}
