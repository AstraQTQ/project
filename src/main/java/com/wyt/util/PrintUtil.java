package com.wyt.util;

import java.util.Scanner;
//输入输出工具类
public class PrintUtil {
    public static Scanner sc = new Scanner(System.in);
    public static void print(String msg,long time){
        for(char c:msg.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
    //默认延迟10ms
    public static void print(String msg){
        print(msg,10);
    }
    //打印分割线
    public static void print(){
        System.out.println("=".repeat(10).concat("/n"));
    }
}
