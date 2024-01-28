package com.ytudating.ytudating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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



    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;


}
