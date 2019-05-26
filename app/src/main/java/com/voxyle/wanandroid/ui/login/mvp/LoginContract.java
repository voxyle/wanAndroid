package com.voxyle.wanandroid.ui.login.mvp;

import com.voxyle.wanandroid.base.mvp.IBaseModel;
import com.voxyle.wanandroid.base.mvp.IBaseView;
import com.voxyle.wanandroid.bean.Result;
import com.voxyle.wanandroid.net.OnResultCallBack;

public interface LoginContract {
    interface Model extends IBaseModel {
        /**
         * @param userName
         * @param password
         */
        void login(String userName, String password, OnResultCallBack<Result> callBack);
    }

    interface View extends IBaseView {
        void onSuccess(Object obj);
    }

    interface presenter {
        void login(String username, String password);
    }
}
