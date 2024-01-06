package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.UserInterestService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.UserInterestDao;
import com.ytudating.ytudating.entities.UserInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInterestManager implements UserInterestService {

    private UserInterestDao userInterestDao;


    //userId ve interest texti ver

    @Autowired
    public UserInterestManager(UserInterestDao userInterestDao) {
        this.userInterestDao = userInterestDao;
    }

    @Override
    public Result addUserInterest(UserInterest userInterest) {

        if(userInterest.getInterestId()== 0){
            //boşsa boş mesajı döndür
            return new ErrorResult(Messages.interestNameCannotBeNull);
        }

        if(userInterest.getUserId() == 0){
            //user id boş ise hata mesajı döndür
            return new ErrorResult(Messages.userIdCannotBeNull);
        }

        userInterestDao.save(userInterest);
        return new SuccessResult(Messages.addInterestSuccess);
        //başarılı sonuç döndür
    }

    @Override
    public DataResult<List<UserInterest>> getUserInterests() {
        var result = userInterestDao.findAll();

        if (result.isEmpty()){
            return new SuccessDataResult<List<UserInterest>>(Messages.getInterestsEmpty);
        }

        return new SuccessDataResult<List<UserInterest>>(Messages.getInterestsSuccess);
    }

    @Override
    public DataResult<UserInterest> getUserInterestById(int id) {
        var result = userInterestDao.findById(id);

        if(result == null){
            return new SuccessDataResult<UserInterest>(Messages.interestDoesntExist);
        }

        return new SuccessDataResult<UserInterest>(result, Messages.getInterestByIdSuccess);
    }
}
