package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.User;
import com.ytudating.ytudating.entities.UserSwipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSwipeDao extends JpaRepository<UserSwipe,Integer> {

    UserSwipe findById(int id);

    UserSwipe findBySwiperIdAndSwipedId(int swiperId, int swipedId);
}
