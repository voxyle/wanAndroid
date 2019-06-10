package com.voxyle.wanandroid.base.mvp;

import android.content.Context;

public interface IBaseView {
    void showLoading();

    void dismissLoading();

    void onError(String msg);

}
