package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.GenderService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.GenderDao;
import com.ytudating.ytudating.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderManager implements GenderService {

    private GenderDao genderDao;

    @Autowired
    public GenderManager(GenderDao genderDao) {
        this.genderDao = genderDao;
    }

    @Override
    public Result addGender(Gender gender) {
        if(gender.getGenderName().isEmpty()){
            return new ErrorResult(Messages.genderCannotBeNull);
        }

        return new SuccessResult(Messages.addGenderSuccess);
    }

    @Override
    public DataResult<List<Gender>> getGenders() {
        var result = genderDao.findAll();

        if(result.isEmpty()){
            return new ErrorDataResult<List<Gender>>(Messages.getGendersIsEmpty);
        }

        return new SuccessDataResult<List<Gender>>(result, Messages.getGendersSuccess);
    }

    @Override
    public DataResult<Gender> getGenderById(int id) {
        var result = genderDao.findById(id);

        if(result == null){
            return new SuccessDataResult<Gender>(Messages.genderDoesntExist);
        }

        return new SuccessDataResult<Gender>(result, Messages.getGenderByIdSuccess);
    }
}
