package com.voxyle.wanandroid.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

public class CommomRecyclerAdapter<T> extends RecyclerView.Adapter<CommomViewHolder> {
    private Context context;
    private int headerSize;
    private int footerSize;
    private SparseArray<T> sparseItems;
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
        this.sparseItems = new SparseArray<>();
        this.context = context;
        this.headerSize = 0;
        this.footerSize = 0;
        this.datas = datas;
        this.mutliItemTypeSupport = mutliItemTypeSupport;
        this.onBingView = onBingView;
    }

    @NonNull
    @Override
    public CommomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = getMutliItemTypeSupport().getLayout(viewType);
        return CommomViewHolder.get(context, parent, layoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull CommomViewHolder holder, int position) {
        T data = sparseItems.get(position);
        if (getOnItemClickListener() != null) {
            holder.getItemView().setOnClickListener(v -> getOnItemClickListener().onItemClick(holder, data, position));
        }
        if (getOnItemLongCliekListener() != null) {
            holder.getItemView().setOnLongClickListener(v -> getOnItemLongCliekListener().onItemLongClick(holder, data, position));
        }
        if (getOnBingView() != null) {
            getOnBingView().bind(holder, data, position);
        }
    }

    @Override
    public int getItemCount() {
        int expandSize = getHeaderSize() + getFooterSize();
        int position = getHeaderSize();
        for (T data : datas) {
            sparseItems.get(position++, data);
        }
        return datas == null ? expandSize : expandSize + datas.size();
    }

    @Override
    public int getItemViewType(int position) {

        return getMutliItemTypeSupport().getItemViewType(position, sparseItems.get(position));
    }

    /**
     * 获取指定position数据
     *
     * @param position
     * @return
     */
    public T getData(int position) {
        return sparseItems.get(position);
    }

    /**
     * 获取header个数
     *
     * @return
     */
    public int getHeaderSize() {
        return headerSize;
    }

    /**
     * 设置header个数
     *
     * @param hearderSize
     */
    public void setHeaderSize(int hearderSize) {
        this.headerSize = hearderSize;
    }

    /**
     * 获取footer个数
     *
     * @return
     */
    public int getFooterSize() {
        return footerSize;
    }

    /**
     * 设置footer个数
     *
     * @param footerSize
     */
    public void setFooterSize(int footerSize) {
        this.footerSize = footerSize;
    }


    /**
     * 多布局选择器
     *
     * @param mutliItemTypeSupport
     */
    public void setMutliItemTypeSupport(MutliItemType<T> mutliItemTypeSupport) {
        this.mutliItemTypeSupport = mutliItemTypeSupport;
    }

    private MutliItemType<T> getMutliItemTypeSupport() {
        return mutliItemTypeSupport;
    }


    /**
     * item单击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener<T> getOnItemClickListener() {
        return onItemClickListener;
    }

    /**
     * item长按事件
     *
     * @param onItemLongCliekListener
     */
    public void setOnItemLongCliekListener(OnItemLongCliekListener<T> onItemLongCliekListener) {
        this.onItemLongCliekListener = onItemLongCliekListener;
    }

    private OnItemLongCliekListener<T> getOnItemLongCliekListener() {
        return onItemLongCliekListener;
    }


    /**
     * 绑定布局
     *
     * @param onBingView
     */
    public void setOnBingView(OnBingView<T> onBingView) {
        this.onBingView = onBingView;
    }

    private OnBingView<T> getOnBingView() {
        return onBingView;
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
