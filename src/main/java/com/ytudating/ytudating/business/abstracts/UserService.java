package com.ytudating.ytudating.business.abstracts;

import com.ytudating.ytudating.core.utilities.result.DataResult;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService extends UserDetailsService {

    Result addUser(User user);

    DataResult<List<User>> getUsers();

    DataResult<User> getUserById(int id);

    DataResult<User> getByUsername(String username);

    UserDetails loadUserByUsername(String username);


}
