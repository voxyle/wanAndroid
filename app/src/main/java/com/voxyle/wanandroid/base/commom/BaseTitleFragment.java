package com.voxyle.wanandroid.base.commom;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.mvp.BasePresenter;

public abstract class BaseTitleFragment<P extends BasePresenter> extends BasePresenterFragment<P>{
    private TextView tv_title;
    private LinearLayout linear_search;
    private ImageView img_add;

    @Override
    protected void initView(View view) {

        tv_title = view.findViewById(R.id.tv_title);
        linear_search = view.findViewById(R.id.linear_search);
        img_add = view.findViewById(R.id.img_add);
        tv_title.setText(titleName());
        linear_search.setOnClickListener(v -> {});
        img_add.setOnClickListener(v -> {
        });
    }

    protected abstract String titleName();


}
