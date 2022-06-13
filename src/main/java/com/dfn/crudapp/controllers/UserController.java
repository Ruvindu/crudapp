package com.dfn.crudapp.controllers;

import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/v1")
@RestController
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//  Get all users
    @GetMapping(path = "/getusers")
    public List<User> getUsers() {
        return userService.getUsers();
    }
//  Get specific user by id
    @GetMapping(path = "getuser/{uid}")
    public User getuser(@PathVariable Long uid) {
        return userService.getUser(uid);
    }
//  Create new user
    @PostMapping(path = "/adduser")
    public Map<String, String> createUser(@RequestBody User user) {

        Map<String, String> map = new HashMap<>();
        try {
            userService.createUser(user);
            map.put("message", "User has been successfully created.");
            return map;
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return map;
        }

    }
//  Update existing user
    @PutMapping(path = "/updateuser")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "update user";
    }
//  Delete user
    @DeleteMapping(path = "/deleteuser/{uid}")
    public Map<String, String> putUsers(@PathVariable Long uid) {

        Map<String, String> map = new HashMap<>();
        try {
            userService.deleteUser(uid);
            map.put("message", "User has been successfully deleted.");
            return map;
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return map;
        }
    }
//Get 5 users

    @GetMapping(path = "/getlast5")
    public List<User> get5Users(){
        return userService.get5Users();
    }
}
