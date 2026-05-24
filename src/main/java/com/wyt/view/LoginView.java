package com.wyt.view;

import com.wyt.controller.UserController;
import com.wyt.util.PrintUtil;
    //登陆界面
public class LoginView {
    public static void loginView() {
        PrintUtil.sc.nextLine();
        PrintUtil.print("请输入用户名");
        String inputUsername =PrintUtil.sc.nextLine();
        if (inputUsername.trim().isEmpty()) {
            PrintUtil.print("用户名不能为空！");
            return;
        }
        PrintUtil.print("请输入密码");
        String inputPassword = PrintUtil.sc.nextLine();
        if (inputPassword.trim().isEmpty()) {
            PrintUtil.print("密码不能为空！");
            return;
        }
        PrintUtil.print("登陆中...🐱");
        UserController.login(inputUsername,inputPassword);
    }
}
