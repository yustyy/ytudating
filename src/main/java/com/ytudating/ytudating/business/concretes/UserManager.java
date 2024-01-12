package com.ytudating.ytudating.business.concretes;

import com.ytudating.ytudating.business.abstracts.UserService;
import com.ytudating.ytudating.business.constants.Messages;
import com.ytudating.ytudating.core.utilities.result.*;
import com.ytudating.ytudating.dataAccess.abstracts.UserDao;
import com.ytudating.ytudating.entities.User;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result addUser(User user) {

        //name ve lastname birlikte kontrol edilsi pipe ile ||
        if(user.getName().isEmpty() || user.getLastName().isEmpty()){
            return new ErrorResult(Messages.nameOrSurnameCannotBeNull);
        }

        if(user.getProfilePicture().isEmpty()){
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



        userDao.save(user);
        return new SuccessResult(Messages.addUserSuccess);
    }

    @Override
    public DataResult<List<User>> getUsers() {
        var result = userDao.findAll();

        if(result.isEmpty()){
            return new SuccessDataResult<List<User>>(Messages.getUsersEmpty);
        }

        return new SuccessDataResult<List<User>>(result, Messages.getUsersSuccess);

    }

    @Override
    public DataResult<User> getUserById(int id) {
        var result = userDao.findById(id);

        if(result == null){
            return new SuccessDataResult<User>(Messages.userDoesntExist);
        }

        return new SuccessDataResult<User>(Messages.getUserByIdSuccess);

    }
}
