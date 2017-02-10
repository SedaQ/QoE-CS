package com.seda.vutbr.feec.dao;

import com.seda.vutbr.feec.entity.User;

import java.util.List;

/**
 * Created by Seda on 10/13/2016.
 */
public interface UserDao {
    public void create(User u);
    public List<User> findAll();
}
