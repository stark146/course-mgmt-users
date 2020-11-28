package com.coursemanagement.app.service;

import com.coursemanagement.app.model.Users;
import com.coursemanagement.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public Users findByUserName(String username){
        return usersRepository.findByUsername(username).orElse(null);
    }

    public List<String> findUserNamesByIdList(List<Long> idList){
        return usersRepository.findByIdList(idList);
    }
}
