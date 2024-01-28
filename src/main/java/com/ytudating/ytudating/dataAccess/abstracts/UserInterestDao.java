package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterestDao extends JpaRepository<UserInterest,Integer> {

    UserInterest findById(int id);

}
