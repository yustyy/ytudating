package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.Faculty;

import java.util.List;

public interface FacultyService {
    Result addFaculty(Faculty faculty);

    DataResult<List<Faculty>> getFaculties();

    DataResult<Faculty> getFacultyById(int id);


}
