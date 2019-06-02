package com.voxyle.wanandroid.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class CommomRecyclerAdapter<T> extends RecyclerView.Adapter<CommomViewHolder> {
    private Context context;
    private int hearderSize;
    private int footerSize;
    private List<T> datas;
    private MutliItemType<T> mutliItemTypeSupport;
    private OnItemClickListener<T> onItemClickListener;
    private OnItemLongCliekListener<T> onItemLongCliekListener;
    private OnBingView<T> onBingView;

    public CommomRecyclerAdapter(@NonNull Context context, List<T> datas, @LayoutRes int layoutId) {
        this(context, datas, itemType -> layoutId);
    }

    public CommomRecyclerAdapter(@NonNull Context context, List<T> datas, MutliItemType<T> mutliItemTypeSupport) {
        this(context, datas, mutliItemTypeSupport, null);
    }

    public CommomRecyclerAdapter(@NonNull Context context, List<T> datas, MutliItemType<T> mutliItemTypeSupport, OnBingView<T> onBingView) {
        this.context = context;
        this.hearderSize = 0;
        this.footerSize = 0;
        this.datas = datas;
        this.mutliItemTypeSupport = mutliItemTypeSupport;
        this.onBingView = onBingView;

    }

    @NonNull
    @Override
    public CommomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = mutliItemTypeSupport.getLayout(viewType);
        return CommomViewHolder.get(context, parent, layoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull CommomViewHolder holder, int position) {
        T data = datas.get(position);
        if (onItemClickListener != null) {
            holder.getItemView().setOnClickListener(v -> onItemClickListener.onItemClick(holder, data, position));
        }
        if (onItemLongCliekListener != null) {
            holder.getItemView().setOnLongClickListener(v -> onItemLongCliekListener.onItemLongClick(holder, data, position));
        }
        if (onBingView != null) {
            onBingView.bind(holder, data, position);
        }
    }

    @Override
    public int getItemCount() {
        int expandSize = getHearderSize() + getFooterSize();
        return datas == null ? expandSize : expandSize + datas.size();
    }

    public int getHearderSize() {
        return hearderSize;
    }

    public void setHearderSize(int hearderSize) {
        this.hearderSize = hearderSize;
    }

    public int getFooterSize() {
        return footerSize;
    }

    public void setFooterSize(int footerSize) {
        this.footerSize = footerSize;
    }

    public MutliItemType<T> getMutliItemTypeSupport() {
        return mutliItemTypeSupport;
    }

    public void setMutliItemTypeSupport(MutliItemType<T> mutliItemTypeSupport) {
        this.mutliItemTypeSupport = mutliItemTypeSupport;
    }

    public OnItemClickListener<T> getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemLongCliekListener<T> getOnItemLongCliekListener() {
        return onItemLongCliekListener;
    }

    public void setOnItemLongCliekListener(OnItemLongCliekListener<T> onItemLongCliekListener) {
        this.onItemLongCliekListener = onItemLongCliekListener;
    }

    public OnBingView<T> getOnBingView() {
        return onBingView;
    }

    public void setOnBingView(OnBingView<T> onBingView) {
        this.onBingView = onBingView;
    }

    public interface MutliItemType<T> {
        @LayoutRes
        int getLayout(int itemType);

        default int getItemViewType(int position, T data) {
            return 0;
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(CommomViewHolder holder, T data, int position);
    }

    public interface OnItemLongCliekListener<T> {
        boolean onItemLongClick(CommomViewHolder holder, T data, int position);
    }

    public interface OnBingView<T> {
        void bind(CommomViewHolder holder, T data, int itemType);
    }
}
