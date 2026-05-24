package com.wyt.view;

import com.wyt.controller.UserController;
import com.wyt.util.PrintUtil;
    //登陆界面
public class LoginView {
    public static void loginView() {
        PrintUtil.print("请输入用户名");
        String inputUsername =PrintUtil.sc.nextLine();
        PrintUtil.print("请输入密码");
        String inputPassword = PrintUtil.sc.nextLine();
        PrintUtil.print("登陆中...🐱");
        UserController.login(inputUsername,inputPassword);
    }
}
