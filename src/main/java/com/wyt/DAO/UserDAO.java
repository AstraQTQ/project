package com.wyt.DAO;

import com.wyt.entity.AdminUser;

public interface UserDAO {
    int selectByUserNameAndPassword(String username, String password);
    int selectByUsername(String username);
    int insertUser(AdminUser adminUser);
    int updateUser(AdminUser adminUser);
    AdminUser selectById(Long id);
}
