package com.voxyle.wanandroid.base.commom;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.voxyle.wanandroid.base.mvp.BasePresenter;
import com.voxyle.wanandroid.base.mvp.IBaseView;

public abstract class BasePresenterActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
