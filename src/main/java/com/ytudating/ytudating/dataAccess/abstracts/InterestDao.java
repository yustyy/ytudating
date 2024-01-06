package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestDao extends JpaRepository<Interest, Integer> {

    Interest findById(int id);

}
