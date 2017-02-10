package com.seda.vutbr.feec.dao;

import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.seda.vutbr.feec.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Seda on 10/13/2016.
 */
public class UserDaoImpl  extends OrmLiteBaseActivity<DatabaseHelper> implements UserDao {
    @Override
    public void create(User user) {
        try {
            getHelper().getUserDao().create(user);
        } catch (SQLException e) {
            Log.e(UserDaoImpl.class.getName(),"Cannot save new user to DB: " + e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = null;
        try {
            allUsers = getHelper().getUserDao().queryForAll();
        } catch (SQLException e) {
            Log.e(UserDaoImpl.class.getName(),"Cannot get all users from DB: " + e);
        }
        return allUsers;
    }

}
