package com.ytudating.ytudating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_interests")
public class UserInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "interest")
    private int interestId;


}
