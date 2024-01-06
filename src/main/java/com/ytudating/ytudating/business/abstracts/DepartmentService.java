package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Department;

import java.util.List;

public interface DepartmentService {

    Result addDepartment(Department department);

    DataResult<List<Department>> getDepartments();

    DataResult<Department> getDepartmentById(int id);

}
