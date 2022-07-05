package com.dfn.crudapp.controllers;

import com.dfn.crudapp.dto.UserDTO;
import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/v1")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//  Get all users
    @GetMapping(path = "/getusers")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
//  Get specific user by id
    @GetMapping(path = "getuser/{uid}")
    public ResponseEntity<User> getuser(@PathVariable Long uid) {
        //create dto object and assign properties without password, then return userdto using ResponseEntity with 200 status
        try {
            return  ResponseEntity.ok().body(userService.getUser(uid));
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }


    }
//  Create new user
    @PostMapping(path = "/add-partial-user")
    public ResponseEntity createUser(@RequestBody User user) {

        try {
            userService.createPartialUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
//            throw new IllegalStateException("User can't be create");
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping(path = "/adduser")
    public ResponseEntity createUser(@RequestBody UserDTO userdto) {

        try {
            userService.createUser(userdto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
//            throw new IllegalStateException("User can't be create");
            return ResponseEntity.internalServerError().build();
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
