package com.wyt.controller;

import com.wyt.service.Impl.UserServiceImpl;
import com.wyt.service.UserService;
import com.wyt.util.PrintUtil;
import com.wyt.view.LoginView;
import com.wyt.view.MainView;
import com.wyt.view.RegisterView;
//该控制器实现用户的登录与注册功能
public class UserController {
    private static UserService userService = new UserServiceImpl();

    //登录功能
    public static void login(String inputUsername, String inputPassword) {
        boolean result = userService.login(inputUsername,inputPassword);
     if(result){
         //登录
         PrintUtil.print("登陆成功！后续功能继续补全");
     }else{
         PrintUtil.print("登陆失败！请重新输入");
         LoginView.loginView();
     }
    }

    //注册功能
    public static void register(String inputUsername, String inputPassword) {
        boolean result = userService.register(inputUsername,inputPassword);
        if(result){
            PrintUtil.print("注册成功！即将跳转到主界面");
            MainView.mainView();
        }else{
            PrintUtil.print("注册失败！请重新输入");
            RegisterView.registerView();
        }
    }
}
