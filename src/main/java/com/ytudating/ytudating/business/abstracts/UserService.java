package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.User;

import java.util.List;

public interface UserService {

    Result addUser(User user);

    DataResult<List<User>> getUsers();

    DataResult<User> getUserById(int id);

}
