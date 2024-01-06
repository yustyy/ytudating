package com.ytudating.ytudating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_swipes")
public class UserSwipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "swiper_id")
    private int swiperId;

    @Column(name = "swiped_id")
    private int swipedId;

    @Column(name = "swipe_type")
    private String swipeType;

    @Column(name = "swipe_date")
    private Date swipeDate;

}
