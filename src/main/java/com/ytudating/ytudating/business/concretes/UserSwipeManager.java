package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.UserSwipeService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.UserSwipeDao;
import com.ytudating.ytudating.entities.Interest;
import com.ytudating.ytudating.entities.UserSwipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSwipeManager implements UserSwipeService {


    private UserSwipeDao userSwipeDao;

    @Autowired
    public UserSwipeManager(UserSwipeDao userSwipeDao) {
        this.userSwipeDao = userSwipeDao;
    }

    @Override
    public Result addUserSwipe(UserSwipe userSwipe) {
        if(userSwipe.getSwipedId() == 0){
            return new ErrorResult(Messages.userSwipeIdCannotBeNull);
        }

        if(userSwipe.getSwiperId() == 0){
            return new ErrorResult(Messages.userSwiperIdCannotBeNull);
        }

        if(userSwipe.getSwipeDate() == null){
            return new ErrorResult(Messages.swipeDateCannotBeNull);
        }

        if(userSwipe.getSwipeType().isEmpty()){
            return new ErrorResult(Messages.swipeTypeCannotBeNull);
        }

        return new SuccessResult(Messages.addUserSwipeSuccess);

    }

    @Override
    public DataResult<List<UserSwipe>> getUserSwipes() {
        var result = userSwipeDao.findAll();

        if(result.isEmpty()){
            return new ErrorDataResult<List<UserSwipe>>(Messages.userSwipesEmpty);
        }

        return new SuccessDataResult<List<UserSwipe>>(result, Messages.getUserSwipeSuccess);

    }

    @Override
    public DataResult<UserSwipe> getUserSwipeById(int id) {
        var result = userSwipeDao.findById(id);

        if(result == null){
            return new SuccessDataResult<UserSwipe>(Messages.userSwiperDoesntExist);
        }
        return new SuccessDataResult<UserSwipe>(result, Messages.getUserSwipeByIdSuccess);
    }

    @Override
    public DataResult<List<UserSwipe>> getAllUserSwipeBySwiperId(int swiperId) {
        var result = userSwipeDao.findAllBySwiperId(swiperId);

        if(result == null){
            return new SuccessDataResult<List<UserSwipe>>("User swipe doesn't exist");
        }
        return new SuccessDataResult<List<UserSwipe>>(result, "User swipe found");
    }

    @Override
    public Result isSwiped(int swiperId, int swipedId) {
        var result = userSwipeDao.findBySwiperIdAndSwipedId(swiperId,swipedId);

        if(result == null){
            return new ErrorResult();
        }
        return new SuccessResult();
    }


}

