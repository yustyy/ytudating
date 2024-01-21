package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.UserService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.UserDao;
import com.ytudating.ytudating.entities.Role;
import com.ytudating.ytudating.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserManager implements UserService, UserDetailsService {

    private UserDao userDao;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Result addUser(User user) {

        /*


        //name ve lastname birlikte kontrol edilsi pipe ile ||
        if(user.getFirstName().isEmpty() || user.getLastName().isEmpty()){
            return new ErrorResult(Messages.nameOrSurnameCannotBeNull);
        }

        if(user.getProfilePicture() == null){
            return new ErrorResult(Messages.profilePictureCannotBeEmpty);
        }

        //profile pic



        //date of birth
        if(user.getDateOfBirth() == null){
            return new ErrorResult(Messages.dateCannotBeNull);
        }

        //gender
        if(user.getGenderId() == 0){
            return new ErrorResult(Messages.genderCannotBeNull);
        }

        //sexual orientation
        if(user.getSexualOrientationGenderId() == 0){
            return new ErrorResult(Messages.sexualOrientationGenderCannotBeNull);
        }

        //school mail
        if(user.getSchoolMail().isEmpty()){
            return new ErrorResult(Messages.schoolMailCannotBeNull);
        }

        //faculty and department
        if(user.getDepartmentId() == 0 || user.getFacultyId() == 0){
            return new ErrorResult(Messages.departmentOrFacultyCannotBeNull);
        }


         */

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setAuthorities();

        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonLocked(true);



        userDao.save(user);
        return new SuccessResult(Messages.addUserSuccess);
    }

    @Override
    public DataResult<List<User>> getUsers() {
        var result = userDao.findAll();

        if(result.isEmpty()){
            return new ErrorDataResult<List<User>>(Messages.getUsersEmpty);
        }

        return new SuccessDataResult<List<User>>(result, Messages.getUsersSuccess);

    }

    @Override
    public DataResult<User> getUserById(int id) {
        var result = userDao.findById(id);

        if(result == null){
            return new ErrorDataResult<User>(Messages.userDoesntExist);
        }

        return new SuccessDataResult<User>(Messages.getUserByIdSuccess);

    }

    @Override
    public DataResult<User> getByUsername(String username) {
        var result = userDao.findByUsername(username);
        if(result == null){
            return new ErrorDataResult<User>(Messages.userDoesntExist);
        }

        return new SuccessDataResult<User>(result, Messages.getUserByUsernameSuccess);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getByUsername(username).getData();
        return user;
    }
}
