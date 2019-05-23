package com.voxyle.wanandroid.base.mvp;

import android.content.Context;

public interface IBaseView {
    void showLoading();

    void dismissLoading();

    void onEmpty(Object obj);

    void onError(Object obj, String msg);

    void onSuccess(Object obj);

    void onFailure(Object obj);

    Context getContext();
}
