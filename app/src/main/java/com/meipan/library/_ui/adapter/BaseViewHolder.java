package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.meipan.library.utils.DisplayUtils;


/**
 * Created by gaoyan on 17/3/4.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public View mItemView;
    private OnRecyclerViewItemClickListener mItemClickListener;

    public BaseViewHolder(View itemView, OnRecyclerViewItemClickListener itemClickListener) {
        super(itemView);
        mItemView = itemView;
        mItemClickListener = itemClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(mItemView, getPosition());
        }
    }

    public void updateItemViewParams(Context mContext, int index) {
        final RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        final int space = DisplayUtils.dpToPxInt(mContext, 5); // R.dimen.space
        final int halfSpace = space >> 1;
        final boolean firstCloumn = index % 2 == 0;
        final boolean firstLine = index / 2 == 0;
        lp.setMargins(firstCloumn ? space : halfSpace, firstLine ? space : 0, firstCloumn ? halfSpace : space, space);
        mItemView.setLayoutParams(lp);
    }

    public void updateItemViewHeaderParams(Context mContext, int index) {
        final RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        final int space = DisplayUtils.dpToPxInt(mContext, 5); // R.dimen.space
        final int halfSpace = space >> 1;
        final boolean firstCloumn = index % 2 == 0;
        final boolean firstLine = index / 2 == 0;
        lp.setMargins(firstCloumn ? space : halfSpace, firstLine ? 0 : 0, firstCloumn ? halfSpace : space, space);
        mItemView.setLayoutParams(lp);
    }

}
