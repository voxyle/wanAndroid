package com.voxyle.wanandroid.ui.login.mvp;

import android.content.Context;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.mvp.BasePresenter;
import com.voxyle.wanandroid.bean.Result;
import com.voxyle.wanandroid.net.OnResultCallBack;

import retrofit2.Call;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> implements LoginContract.presenter {

    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }

    @Override
    protected void init() {

    }

    @Override
    public void login(String username, String password) {
        showLoading();
        getModel().login(username, password, new OnResultCallBack<Result>() {
            @Override
            public void onSuccessful(Call<Result> call, Response<Result> response) {
                getmView().onSuccess(response.body());
            }

            @Override
            public void onFailure(String tag, Response<Result> response) {
                if (response != null) {
                    getmView().onError(response.body().getErrorMsg());
                } else {
                    getmView().onError(getContext().getString(R.string.login_time_out));
                }
            }

            @Override
            public void onCompleted() {
                disLoading();
            }
        });
    }

    @Override
    public Context getContext() {
        return getmView().getContext();
    }

}
