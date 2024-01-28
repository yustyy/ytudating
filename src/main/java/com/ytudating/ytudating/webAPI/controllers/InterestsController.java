package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.InterestService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/interests")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3000/signup" })
public class InterestsController {

    private InterestService interestService;

    @Autowired
    public InterestsController(InterestService interestService) {
        this.interestService = interestService;
    }

    @PostMapping("/addInterest")
    public Result addInterest(@RequestBody Interest interest){
        return interestService.addInterest(interest);
    }

    @GetMapping("/getInterests")
    public DataResult<List<Interest>> getInterests(){
        return interestService.getInterests();
    }

    @GetMapping("/getInterestById")
    public DataResult<Interest> getInterestById(@RequestParam int interestId){
        return interestService.getInterestById(interestId);
    }
}
