package com.coursemanagement.app.service;

import com.coursemanagement.app.model.Users;

import java.util.List;

public interface UsersService {

    public Users saveUser(Users users);

    public Users findByUserName(String username);

    public List<String> findUserNamesByIdList(List<Long> idList);
}
