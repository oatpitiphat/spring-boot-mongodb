package com.pocmongodb.demo.controller;

import com.pocmongodb.demo.model.User;
import com.pocmongodb.demo.service.UserService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(path = "/api/user/getData")
    public ResponseEntity getUser() {
        List<User> users = new ArrayList<>();
        try {
            users = userService.findAllUser();
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(path = "/api/user/getDataByName")
    public ResponseEntity getUserByName(@RequestParam String name) {
        User user;
        try {
            user = userService.findByName(name);
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData by name");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping(path = "/api/user/getDataByRoleName")
    public ResponseEntity getUserByRoleName(@RequestParam String roleName, String roleDesc) {
        List<User> users = new ArrayList<>();
        try {
            users = userService.findAllByRoleName(roleName, roleDesc);
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData by role name");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping(path = "/api/user/save")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            System.out.println(user);
           User response = userService.createUser(user);
           return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "api/user/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        try {
            boolean response = userService.deleteUserById(id);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "api/user/groupAge")
    public ResponseEntity groupAge() {
        return new ResponseEntity(userService.groupAge(), HttpStatus.OK);
    }
}
