package com.voxyle.wanandroid.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.commom.BaseActivity;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomView;

    @Override
    protected int onLayoutId() {
        return R.layout.avtivity_fragment;
    }


    @Override
    protected void initView() {
        mBottomView = findViewById(R.id.bottom_view);
        mBottomView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_find:

                break;
            case R.id.item_project:

                break;
            case R.id.item_my:

                break;

        }
        return false;
    }
}
