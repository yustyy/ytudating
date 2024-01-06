package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.FacultyService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.FacultyDao;
import com.ytudating.ytudating.entities.Department;
import com.ytudating.ytudating.entities.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {

    private FacultyDao facultyDao;

    @Autowired
    public FacultyManager(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public Result addFaculty(Faculty faculty) {

        if(faculty.getFacultyName().isEmpty()){
            return new ErrorResult(Messages.facultyNameCannotBeNull);
        }

        facultyDao.save(faculty);
        return new SuccessResult(Messages.facultyAddSuccess);

    }

    @Override
    public DataResult<List<Faculty>> getFaculties() {
        var result = facultyDao.findAll();
        if(result.isEmpty()){
            return new SuccessDataResult<List<Faculty>>(Messages.getFacultiesIsEmpty);
        }

        return new SuccessDataResult<List<Faculty>>(result, Messages.getFacultySuccess);
    }

    @Override
    public DataResult<Faculty> getFacultyById(int id) {
        var result = facultyDao.findById(id);

        if(result == null){
            return new SuccessDataResult<Faculty>(Messages.facultyDoesntExist);
        }

        return new SuccessDataResult<Faculty>(result, Messages.getFacultyByIdSuccess);

    }
}
