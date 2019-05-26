package com.voxyle.wanandroid.widget;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.voxyle.wanandroid.R;
import com.voxyle.wanandroid.base.commom.BaseDialog;

public class LoginDialog extends BaseDialog {
    private ImageView img_load;

    public LoginDialog(@NonNull Context context) {
        super(context, R.layout.dialog_login_loading, null);
    }

    @Override
    public void initView() {
        img_load = findViewById(R.id.img_load);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Animation rotate = AnimationUtils.loadAnimation(context, R.anim.anim_login_loading);
        img_load.startAnimation(rotate);
    }

    @Override
    protected void onStop() {
        super.onStop();
        img_load.clearAnimation();
    }
}
