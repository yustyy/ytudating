package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.UserInterest;

import java.util.List;

public interface UserInterestService {

    Result addUserInterest(UserInterest userInterest);

    DataResult<List<UserInterest>> getUserInterests();

    DataResult<UserInterest> getUserInterestById(int id);

}
