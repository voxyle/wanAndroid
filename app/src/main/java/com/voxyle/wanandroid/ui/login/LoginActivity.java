package com.voxyle.wanandroid.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.commom.BaseActivity;
import com.voxyle.wanandroid.ui.login.mvp.LoginContract;
import com.voxyle.wanandroid.ui.login.mvp.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter>implements LoginContract.View , View.OnClickListener {
    private EditText mUserName;
    private EditText mPassWord;
    private CheckBox mCheckPassWord;
    private AppCompatImageView mLogin;
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
        mPassWord =findViewById(R.id.password);
        mCheckPassWord = findViewById(R.id.check_password);
        mLogin = findViewById(R.id.login);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onEmpty(Object obj) {

    }

    @Override
    public void onError(Object obj, String msg) {

    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onFailure(Object obj) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                presenter.login();
                break;
        }
    }
}
