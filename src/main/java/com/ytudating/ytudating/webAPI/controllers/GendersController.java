package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.GenderService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genders")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3000/signup" })
public class GendersController {

    private GenderService genderService;

    @Autowired
    public GendersController(GenderService genderService){
        this.genderService = genderService;
    }

    @PostMapping("/add")
    public Result addGender(@RequestBody Gender gender){
        return genderService.addGender(gender);
    }

    @GetMapping("/getGenders")
    public DataResult<List<Gender>> getGenders() {
        return genderService.getGenders();
    }

    @GetMapping("/getGenderById")
    public DataResult<Gender> getGenderById(@RequestParam int genderId){
        return genderService.getGenderById(genderId);
    }


}

