package com.UserProfile.Controller;

import com.UserProfile.Entities.User;
import com.UserProfile.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }


}
