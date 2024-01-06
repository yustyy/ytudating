package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.UserSwipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSwipeDao extends JpaRepository<UserSwipe,Integer> {

    UserSwipe findById(int id);
}
