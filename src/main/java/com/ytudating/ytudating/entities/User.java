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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender_id")
    private int genderId;

    @Column(name = "sexual_orientation_gender_id")
    private int sexualOrientationGenderId;

    @Column(name = "school_mail")
    private String schoolMail;

    @Column(name = "faculty_id")
    private int facultyId;

    @Column(name = "department_id")
    private int departmentId;



}
