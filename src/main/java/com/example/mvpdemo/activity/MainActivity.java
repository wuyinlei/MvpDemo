package com.example.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private EditText etUserName;
    private EditText etPassword;
    private Button btn;
    private TextView tvResult;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    /**
     * 初始化布局控件
     */
    private void initialize() {

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btn = (Button) findViewById(R.id.btn);

        tvResult = (TextView) findViewById(R.id.tvResult);

       /* userName = etUserName.getText().toString();
        pwd = etPassword.getText().toString();*/

        initLogin();
    }

    /**
     * 登录
     *
     * 在这里我们只有使用了Presenter层和View层的交互，没有了所谓的model和view的交互
     */
    private void initLogin() {
        mPresenter = new LoginPresenter(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*login(etUserName.getText().toString(), etPassword.getText().toString());

                if (!TextUtils.isEmpty(result)) {
                    mUserEntity = new Gson().fromJson(result, UserEntity.class);
                    tvResult.setText(mUserEntity.address.toString());
                }*/

                mPresenter.login();
            }
        });
    }

    @Override
    public String getUerName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPwd() {
        return etPassword.getText().toString();
    }

    @Override
    public void onUserNameError() {
        etUserName.setError("用户名不能为空");
    }

    @Override
    public void onPwdError() {
        etPassword.setError("密码不能为空");
    }

    @Override
    public void onError() {
        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String address) {
        tvResult.setText(address);
    }


   /* *//**
     * 登录逻辑
     *//*
    private void login(String userName, String pwd) {
        if (TextUtils.isEmpty(userName)) {
            etUserName.setError("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            etPassword.setError("密码不能为空");
            return;
        }
        if ("123".equals(pwd)) {

            result = "{\n" +
                    "    \"nickName\": \"小明\",\n" +
                    "    \"userID\": \"1212\",\n" +
                    "    \"address\": \"河南周口\"\n" +
                    "}";

        } else {
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            return;
        }
    }
*/

}
