package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Gender;

import java.util.List;

public interface GenderService {

    Result addGender(Gender gender);

    DataResult<List<Gender>> getGenders();

    DataResult<Gender> getGenderById(int id);
}
