package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findById(int id);

    Optional<User> findByUsername(String userName);

}
