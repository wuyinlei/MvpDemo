package com.example.mvpdemo.view;

/**
 * Created by 若兰 on 2016/1/13.
 * 一个懂得了编程乐趣的小白，希望自己
 * 能够在这个道路上走的很远，也希望自己学习到的
 * 知识可以帮助更多的人,分享就是学习的一种乐趣
 * QQ:1069584784
 * csdn:http://blog.csdn.net/wuyinlei
 */

/**
 * view层,在这里只有view的表达
 */
public interface LoginView {

    String getUerName();
    String getPwd();

    /**
     * 处理用户名没有输入为空
     */
    void onUserNameError();

    /**
     * 处理密码没有输入为空
     */
    void onPwdError();

    /**
     * 处理用户密码输入错误
     */
    void onError();

    /**
     * 成功登录
     * @param address
     */
    void onSuccess(String address);
}
