package com.wyt.service.Impl;

import com.wyt.DAO.Impl.UserDAOImpl;
import com.wyt.DAO.UserDAO;
import com.wyt.entity.AdminUser;
import com.wyt.entity.Status;
import com.wyt.service.UserService;
import com.wyt.util.MD5Util;

public class UserServiceImpl implements UserService {
    private  static UserDAO userDAO = new UserDAOImpl();
    //登录功能
    @Override
    public boolean login(String username, String password) {
        password = MD5Util.getMD5(password);
        int result = userDAO.selectByUserNameAndPassword(username,password);
        return result > 0 ? true : false;
    }
    //注册功能
    @Override
    public boolean register(String username, String password) {
        int isExist = userDAO.selectByUsername(username);
        if(isExist > 0){
            return false;
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(MD5Util.getMD5(adminUser.getPassword()));
        adminUser.setStatus(Status.active);
        int result = userDAO.insertUser(adminUser);
        return result > 0;
    }
    @Override
    public boolean deleteUser(String username) {
        return false;
    }

    @Override
    public boolean selectUserById(Long id) {
        return false;
    }

    @Override
    public boolean selectUserByUsername(String username) {
        return false;
    }

    @Override
    public boolean updateUser(String username, String password) {
        return false;
    }

    @Override
    public boolean selectUserByUsernameAndPassword(String username, String password) {
        return false;
    }
}
