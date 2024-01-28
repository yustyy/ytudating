package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Gender;
import com.ytudating.ytudating.entities.Interest;

import java.util.List;

public interface InterestService {

    Result addInterest(Interest interest);

    DataResult<List<Interest>> getInterests();

    DataResult<Interest> getInterestById(int id);

}
