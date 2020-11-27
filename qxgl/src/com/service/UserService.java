package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {

    public User selectOne(String uname,String upass);

    public List<User> findUserAll();

    public void insert(User user);

    public void delete(Integer uno);

    public User selectOneUser(Integer uno);

    public void update(User user);

    public void deleteUsers(Integer[] unos);
}
