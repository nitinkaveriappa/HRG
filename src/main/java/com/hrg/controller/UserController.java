package com.hrg.controller;

import com.hrg.entity.ErrorStatus;
import com.hrg.entity.JsonRequest;
import com.hrg.entity.User;
import com.hrg.entity.UserJson;
import com.hrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> createNewUser(@RequestBody JsonRequest<User> jsonRequest) {
        User user = userService.createNewUser(jsonRequest.getBody().getEmail(), jsonRequest.getBody().getName(), jsonRequest.getBody().getPassword());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Email Already Registered", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        if(!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("No Users", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity getUserById(@RequestBody JsonRequest<User> jsonRequest) {
        User user = userService.getUserByEmailAndPassword(jsonRequest.getBody().getEmail(), jsonRequest.getBody().getPassword());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Email & Password combo does not exist", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> forgotUserByEmail(@RequestBody JsonRequest<User> jsonRequest) {
        User user = userService.resetUserByEmail(jsonRequest.getBody().getEmail());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("User Not Found", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> resetUserByEmail(@RequestBody JsonRequest<User> jsonRequest) {
        User user = userService.resetUserByEmail(jsonRequest.getBody().getEmail());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("User Not Found", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateUserByEmail(@RequestBody JsonRequest<User> jsonRequest) {
        User user = userService.getUserByEmailAndPassword(jsonRequest.getBody().getEmail(), jsonRequest.getBody().getPassword());
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User Not Found", HttpStatus.OK);
        }
    }
}
