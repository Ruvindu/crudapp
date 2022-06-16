package com.dfn.crudapp.controllers;

import com.dfn.crudapp.dto.UserDTO;
import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDTO> getuser(@PathVariable Long uid) {
        //create dto object and assign properties without password, then return userdto using ResponseEntity with 200 status

        UserDTO userdto = new UserDTO();
        try {
            User user = userService.getUser(uid);
            BeanUtils.copyProperties(user,userdto);
            return  ResponseEntity.ok().body(userdto);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }


    }
//  Create new user
    @PostMapping(path = "/adduser")
    public ResponseEntity createUser(@RequestBody User user) {

        try {
            userService.createUser(user);
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
