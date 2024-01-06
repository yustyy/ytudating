package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDao extends JpaRepository<Gender,Integer> {

    Gender findById(int id);

}
