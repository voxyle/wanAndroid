package com.voxyle.wanandroid.base.commom;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.voxyle.wanandroid.base.mvp.BasePresenter;
import com.voxyle.wanandroid.base.mvp.IBaseView;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    protected abstract P createPresenter();
    protected abstract int getLayoutId();
    protected abstract void initView();

    @Override
    public Context getContext() {
        return null;
    }
}
