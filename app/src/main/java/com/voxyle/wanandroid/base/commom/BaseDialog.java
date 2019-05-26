package com.voxyle.wanandroid.base.commom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class BaseDialog extends Dialog {
    protected OnCloseListener listener;
    protected int layoutId;
    protected Context context;

    public BaseDialog(@NonNull Context context, int layoutId) {
        this(context, layoutId, null);
    }


    public BaseDialog(@NonNull Context context, int layoutId, BaseDialog.OnCloseListener onCloseListener) {
        super(context);
        this.layoutId = layoutId;
        this.context = context;
        this.listener = onCloseListener;

    }

    private BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        setCanceledOnTouchOutside(false);
        initView();
    }

    public abstract void initView();


    public interface OnCloseListener {
        void onConfirm();

        void onCancel();
    }
}
