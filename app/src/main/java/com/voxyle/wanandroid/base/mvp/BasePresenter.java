package com.voxyle.wanandroid.base.mvp;

import android.content.Context;

public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> {
    private M model;
    private V mView;

    public void attachView(V mView) {
        this.mView = mView;
        this.model = createModel();
    }

    public void detachView() {
        this.model = null;
        this.mView = null;

    }

    public M getModel() {
        return model;
    }

    public V getmView() {
        return mView;
    }


    public void showLoading() {
        getmView().showLoading();
    }

    public void disLoading() {
        getmView().dismissLoading();
    }

    protected abstract M createModel();

    protected abstract void init();
}
