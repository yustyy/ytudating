package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.UserSwipeService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.UserSwipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userSwipes")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3000/signup" })
public class UserSwipesController {

    private UserSwipeService userSwipeService;

    @Autowired
    public UserSwipesController(UserSwipeService userSwipeService){
        this.userSwipeService = userSwipeService;
    }

    @PostMapping("/add")
    public Result addUserSwipe(@RequestBody UserSwipe userSwipe){
        return userSwipeService.addUserSwipe(userSwipe);
    }

    @GetMapping("/getUserSwipes")
    public DataResult<List<UserSwipe>> getUserSwipes(){
        return userSwipeService.getUserSwipes();
    }

    @GetMapping("/getUserSwipeById")
    public DataResult<UserSwipe> getUserSwipeById(@RequestParam int userSwipeId){
        return userSwipeService.getUserSwipeById(userSwipeId);
    }

}
