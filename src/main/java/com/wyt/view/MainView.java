package com.wyt.view;

import com.wyt.controller.MainController;
import com.wyt.util.PrintUtil;

public class MainView {
    public static void mainView() {
        PrintUtil.print("🎇智管家个人数字资产管理系统🎇");
        PrintUtil.print();
        PrintUtil.print("请选择操作：");
        PrintUtil.print("1.登录");
        PrintUtil.print("2.注册");
        PrintUtil.print("3.退出");
        String choice = PrintUtil.sc.next();
        //调用Controller进行处理
        MainController.mainController(choice);
    }
}
