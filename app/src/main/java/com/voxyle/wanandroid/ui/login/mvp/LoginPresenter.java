package com.voxyle.wanandroid.ui.login.mvp;

import com.voxyle.wanandroid.base.mvp.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContract.Model,LoginContract.View> implements LoginContract.presenter {

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

    @Override
    protected void init() {

    }

    @Override
    public void login(String username, String password) {

    }
}
