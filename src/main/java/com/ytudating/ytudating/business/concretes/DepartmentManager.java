package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.DepartmentService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.DepartmentDao;
import com.ytudating.ytudating.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Result addDepartment(Department department) {

        if(department.getDepartmentName().isEmpty()){
            return new ErrorResult(Messages.departmentNameCannotBeNull);
        }

            departmentDao.save(department);
            return new SuccessResult(Messages.departmentAddSuccess);
    }

    @Override
    public DataResult<List<Department>> getDepartments() {
        var result = departmentDao.findAll();
        if(result.isEmpty()){
            return new SuccessDataResult<List<Department>>(Messages.getDepartmentsIsEmpty);
        }

        return new SuccessDataResult<List<Department>>(result, Messages.getDepartmentSuccess);
    }

    @Override
    public DataResult<Department> getDepartmentById(int id) {
        var result = departmentDao.findById(id);

        if(result == null){
            return new SuccessDataResult<Department>(Messages.departmentDoesntExist);
        }

        return new SuccessDataResult<Department>(result, Messages.getDepartmentByIdSuccess);

    }
}
