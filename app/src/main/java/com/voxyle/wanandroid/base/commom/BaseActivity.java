package com.voxyle.wanandroid.base.commom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

public abstract class BaseActivity extends AppCompatActivity{
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onLayoutId());
        initView();

    }




    protected abstract int onLayoutId();
    protected abstract void initView();

}
