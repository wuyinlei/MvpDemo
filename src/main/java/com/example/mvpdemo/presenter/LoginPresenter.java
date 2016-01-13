package com.example.mvpdemo.presenter;

import android.text.TextUtils;

import com.example.mvpdemo.model.UserEntity;
import com.example.mvpdemo.view.LoginView;
import com.google.gson.Gson;

/**
 * Created by 若兰 on 2016/1/13.
 * 一个懂得了编程乐趣的小白，希望自己
 * 能够在这个道路上走的很远，也希望自己学习到的
 * 知识可以帮助更多的人,分享就是学习的一种乐趣
 * QQ:1069584784
 * csdn:http://blog.csdn.net/wuyinlei
 */

public class LoginPresenter implements PresenterInterface {

    /**
     * VIEW层，与Presenter进行信息交互
     */
    public LoginView mLoginView;
    public String result;

    public LoginPresenter(LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    @Override
    public void login() {
        if (TextUtils.isEmpty(mLoginView.getUerName())) {
            mLoginView.onUserNameError();
            return;
        }
        if (TextUtils.isEmpty(mLoginView.getPwd())) {
            mLoginView.onPwdError();
            return;
        }
        if ("123".equals(mLoginView.getPwd())) {

            result = "{\n" +
                    "    \"nickName\": \"wuyinlei\",\n" +
                    "    \"userID\": \"1212\",\n" +
                    "    \"address\": \"河南周口\"\n" +
                    "}";

            /**
             * Model层，和Presenter层交互
             */
            UserEntity mUserEntity = new UserEntity();
            mUserEntity = new Gson().fromJson(result, UserEntity.class);
            mLoginView.onSuccess(mUserEntity.address);

        } else {
          mLoginView.onError();
            return;
        }
    }
}
