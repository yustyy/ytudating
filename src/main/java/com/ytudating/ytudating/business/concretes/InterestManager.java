package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.InterestService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.InterestDao;
import com.ytudating.ytudating.entities.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestManager implements InterestService {

    private InterestDao interestDao;

    @Autowired
    public InterestManager(InterestDao interestDao) {
        this.interestDao = interestDao;
    }

    @Override
    public Result addInterest(Interest interest) {

        if (interest.getInterestName().isEmpty()){
            return new ErrorResult(Messages.interestNameCannotBeNull);
        }

        interestDao.save(interest);
        return new SuccessResult(Messages.addInterestSuccess);

    }

    @Override
    public DataResult<List<Interest>> getInterests() {
        var result = interestDao.findAll();

        if(result.isEmpty()){
            return new ErrorDataResult<List<Interest>>(Messages.getInterestsEmpty);
        }

        return new SuccessDataResult<List<Interest>>(result, Messages.getInterestsSuccess);
    }

    @Override
    public DataResult<Interest> getInterestById(int id) {
        var result = interestDao.findById(id);

        if(result.getInterestName().isEmpty()){
            return new ErrorDataResult<Interest>(Messages.interestDoesntExist);
        }

        return new SuccessDataResult<Interest>(result, Messages.getInterestsSuccess);
    }
}
