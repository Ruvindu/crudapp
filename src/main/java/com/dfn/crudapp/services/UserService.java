package com.dfn.crudapp.services;

import com.dfn.crudapp.dto.UserDTO;
import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.List;


@Service

public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createPartialUser(User user) throws Exception {
        userRepo.save(user);
    }

    public void createUser(UserDTO userdto) throws Exception {
        userRepo.save(userdto.getUser());
    }

    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    public User getUser(Long uid) throws Exception{
        return userRepo.findById(uid).get();
    }

    public void deleteUser(Long uid) {
        userRepo.deleteById(uid);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public List<User> get5Users() {
        return userRepo.findLast5Users();
    }
}
