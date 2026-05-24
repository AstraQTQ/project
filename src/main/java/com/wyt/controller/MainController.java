package com.wyt.controller;

import com.wyt.util.PrintUtil;
import com.wyt.view.LoginView;
import com.wyt.view.MainView;
import com.wyt.view.RegisterView;

public class MainController {
   public static void mainController(String userChoice){
       switch (userChoice){
           case "1":
               //登录页面
               LoginView.loginView();
               break;
           case "2":
               //注册页面
               RegisterView.registerView();
               break;
           case "3":
               //退出
               System.out.println("⭐智管家-您的选择⭐");
               System.exit(0);
               break;
           default:
               PrintUtil.print("输入错误，请重新输入");
               PrintUtil.print();
               MainView.mainView();
       }
   }
}
