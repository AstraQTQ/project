package com.wyt.view;

import com.wyt.controller.UserController;
import com.wyt.util.PrintUtil;

public class RegisterView {
    //注册界面
    public static void registerView() {
        PrintUtil.print("请输入用户名");
        String inputUsername =PrintUtil.sc.nextLine();
        PrintUtil.print("请输入密码");
        String inputPassword = PrintUtil.sc.nextLine();
        PrintUtil.print("请再次输入密码");
        String inputPasswordAgain = PrintUtil.sc.nextLine();
        if(inputPassword.equals(inputPasswordAgain)){
            PrintUtil.print("注册中...🐱");
            UserController.register(inputUsername,inputPassword);
        } else{
            PrintUtil.print("两次输入的密码不一致");
            registerView();
        }

    }
}
