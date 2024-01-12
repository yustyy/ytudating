package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.DepartmentService;
import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentsController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public Result addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getDepartments")
    public DataResult<List<Department>> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/getDepartmentById")
    public DataResult<Department> getDepartmentById(@RequestParam int departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

}
