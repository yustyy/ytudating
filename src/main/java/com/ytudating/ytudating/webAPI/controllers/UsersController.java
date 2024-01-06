package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.UserService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestParam User user){
        return userService.addUser(user);
    }

    @GetMapping("/getUsers")
    public DataResult<List<User>> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUserById")
    public DataResult<User> getUserById(@RequestParam int userId){
        return userService.getUserById(userId);
    }

}
