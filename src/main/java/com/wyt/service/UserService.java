package com.wyt.service;

public interface UserService {
     boolean login(String username, String password);
     boolean register(String username, String password);
     boolean updateUser(String username, String password);
     boolean deleteUser(String username);
     boolean selectUserById(Long id);
     boolean selectUserByUsernameAndPassword(String username, String password);
     boolean selectUserByUsername(String username);


}
