package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.UserSwipe;

import java.util.List;

public interface UserSwipeService {
    Result addUserSwipe(UserSwipe userSwipe);


    DataResult<List<UserSwipe>> getUserSwipes();

    DataResult<UserSwipe> getUserSwipeById(int id);

    DataResult<List<UserSwipe>> getAllUserSwipeBySwiperId(int swiperId);

    Result isSwiped(int swiperId, int swipedId);


}

