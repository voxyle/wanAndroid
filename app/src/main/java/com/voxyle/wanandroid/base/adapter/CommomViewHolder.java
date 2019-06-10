package com.voxyle.wanandroid.base.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CommomViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views;

    private CommomViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
    }

    public static CommomViewHolder get(@NonNull Context context, @NonNull ViewGroup parent, @LayoutRes int layoutId) {
        View itemView = LayoutInflater.from(context)
                .inflate(layoutId, parent, false);
        return new CommomViewHolder(itemView);
    }

    /**
     * 通过id获取View
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(@IdRes int id) {
        T view = (T) views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return view;
    }

    /**
     * 获取item
     *
     * @return
     */
    public View getItemView() {
        return itemView;
    }
}
