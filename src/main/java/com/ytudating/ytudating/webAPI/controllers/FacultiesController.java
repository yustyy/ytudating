package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.FacultyService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/faculties")
@CrossOrigin(origins = "http://localhost:3000")
public class FacultiesController {

    private FacultyService facultyService;

    @Autowired
    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public Result addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("/getFaculties")
    public DataResult<List<Faculty>> getFaculties(){
        return facultyService.getFaculties();
    }

    @GetMapping("/getFacultyById")
    public DataResult<Faculty> getFacultyById(@RequestParam int facultyId){
        return facultyService.getFacultyById(facultyId);
    }
}
