package com.voxyle.wanandroid.base.commom;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.voxyle.wanandroid.base.mvp.BasePresenter;
import com.voxyle.wanandroid.base.mvp.IBaseView;

public abstract class BasePresenterFragment<P extends BasePresenter> extends BaseFragment implements IBaseView {
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    public abstract P createPresenter();


}
