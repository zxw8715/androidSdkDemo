package com.xilu.sdk.demo.activity.ad.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xilu.sdk.demo.activity.ad.adapter.holder.NativeExpressAdViewHolder;
import com.xilu.sdk.demo.activity.ad.adapter.holder.NativeFeedAdViewHolder;
import com.xilu.sdk.demo.activity.ad.adapter.holder.NormalDataViewHolder;
import com.xilu.sdk.ad.data.ADXiluNativeAdInfo;
import com.xilu.sdk.ad.data.ADXiluNativeExpressAdInfo;
import com.xilu.sdk.ad.data.ADXiluNativeFeedAdInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ciba
 * @description 信息流广告Adapter
 * @date 2020/4/1
 */
public class NativeAdAdapter extends BaseNativeAdAdapter {
    /**
     * 普通数据类型（模拟数据）
     */
    private static final int ITEM_VIEW_TYPE_NORMAL_DATA = 0;

    // 以下为三种信息流广告适配类型，模板一种，自渲染两种（没有MediaView）和（包含MediaView）。
    /**
     * 信息流原生广告类型（没有MediaView）
     */
    private static final int ITEM_VIEW_TYPE_NATIVE_AD = 1;
    /**
     * 信息流模板广告类型
     */
    private static final int ITEM_VIEW_TYPE_EXPRESS_AD = 3;

    private List<Object> dataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemViewType) {
        switch (itemViewType) {
            case ITEM_VIEW_TYPE_NATIVE_AD:
                return new NativeFeedAdViewHolder(viewGroup);
            case ITEM_VIEW_TYPE_EXPRESS_AD:
                return new NativeExpressAdViewHolder(viewGroup);
            default:
                return new NormalDataViewHolder(viewGroup);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Object item = dataList.get(position);
        if (viewHolder instanceof NormalDataViewHolder) {
            // 普通数据类型的
            ((NormalDataViewHolder) viewHolder).setData((String) item);
        } else if (viewHolder instanceof NativeFeedAdViewHolder) {
            // 信息流原生广告类型
            ((NativeFeedAdViewHolder) viewHolder).setData((ADXiluNativeFeedAdInfo) item);
        } else if (viewHolder instanceof NativeExpressAdViewHolder) {
            // 信息流模板广告类型
            ((NativeExpressAdViewHolder) viewHolder).setData((ADXiluNativeExpressAdInfo) item);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = dataList.get(position);
        if (item instanceof String) {
            return ITEM_VIEW_TYPE_NORMAL_DATA;
        } else if (item instanceof ADXiluNativeExpressAdInfo) {
            // isNativeExpress() true 信息流模版广告
            return ITEM_VIEW_TYPE_EXPRESS_AD;
        } else {
            // isNativeExpress() false 信息流原生广告
            return ITEM_VIEW_TYPE_NATIVE_AD;
        }
    }

    /**
     * 移除广告所在的对象，一般模板广告有可能会渲染失败
     */
    @Override
    public void removeData(ADXiluNativeAdInfo adInfo) {
        if (dataList.contains(adInfo)) {
            // 释放广告Info对象
            adInfo.release();
            // 从数据源中移除
            dataList.remove(adInfo);
            // 通知刷新Adapter
            notifyDataSetChanged();
        }
    }

    /**
     * 刷新数据
     */
    @Override
    public void clearData() {
        dataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     */
    @Override
    public void addData(List<Object> datas) {
        int startPosition = dataList.size();
        dataList.addAll(datas);
        if (startPosition <= 0) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(startPosition + 1, dataList.size() - startPosition);
        }
    }

}
