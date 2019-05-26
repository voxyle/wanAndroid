package com.voxyle.wanandroid.ui.login;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.commom.BaseActivity;
import com.voxyle.wanandroid.ui.login.mvp.LoginContract;
import com.voxyle.wanandroid.ui.login.mvp.LoginPresenter;
import com.voxyle.wanandroid.widget.LoginDialog;

import org.w3c.dom.Text;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener, TextWatcher {
    private EditText mUserName;
    private EditText mPassWord;
    private CheckBox mCheckPassWord;
    private AppCompatImageView mLogin;
    private AnimatedVectorDrawable loginAnim;
    private LoginDialog dialog;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mUserName = findViewById(R.id.username);
        mPassWord = findViewById(R.id.password);
        mCheckPassWord = findViewById(R.id.check_password);
        mLogin = findViewById(R.id.login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            loginAnim = (AnimatedVectorDrawable) mLogin.getDrawable();
        }
        mLogin.setOnClickListener(this);
        dialog = new LoginDialog(this);
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void dismissLoading() {
        dialog.dismiss();
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onSuccess(Object obj) {

    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String userName = mUserName.getText().toString();
                String passWord = mPassWord.getText().toString();
                presenter.login(userName, passWord);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (loginAnim != null) {
            int length = s.length();
            if (length > 0) {
                //开启动画
                if (!loginAnim.isRunning()) {
                    loginAnim.start();
                }
            } else {
                //关闭动画
                if (loginAnim.isRunning()) {
                    loginAnim.stop();
                }
            }
        }
    }
}
