package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.UserInterestService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.UserInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/userInterest")
public class UserInterestsController {

    private UserInterestService userInterestService;

    @Autowired
    public UserInterestsController(UserInterestService userInterestService){
        this.userInterestService = userInterestService;
    }

    @PostMapping("/add")
    public Result addUserInterest(@RequestBody UserInterest userInterest){
        return userInterestService.addUserInterest(userInterest);
    }

    @GetMapping("/getUserInterests")
    public DataResult<List<UserInterest>> getUserInterests(){
        return userInterestService.getUserInterests();
    }

    @GetMapping("getUserInterestById")
    public DataResult<UserInterest> getUserInterestById(@RequestParam int userInterestId){
        return userInterestService.getUserInterestById(userInterestId);
    }


}
