package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoyan on 17/3/12.
 */

public abstract class BaseAdapter<D extends BaseDataHolder> extends RecyclerView.Adapter<BaseViewHolder> implements OnRecyclerViewItemClickListener{

    public Context mContext;
    public final List<D> mDatas=new ArrayList<>();
    public OnRecyclerViewItemClickListener mOnItemClickListener;

    public BaseAdapter(Context context,OnRecyclerViewItemClickListener onItemClickListener){
        mContext=context;
        mOnItemClickListener=onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void clear(){
        mDatas.clear();
        notifyDataSetChanged();
    }
}
