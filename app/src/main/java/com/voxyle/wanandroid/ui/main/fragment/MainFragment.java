package com.voxyle.wanandroid.ui.main.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.commom.BaseTitleFragment;
import com.voxyle.wanandroid.base.mvp.BasePresenter;

public class MainFragment extends BaseTitleFragment {
    private RecyclerView rv_main;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int onLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        rv_main = view.findViewById(R.id.rv_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected String titleName() {
        return getString(R.string.title_find);
    }


    @Override
    protected void onRefreshableData() {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onError(String msg) {

    }
}
