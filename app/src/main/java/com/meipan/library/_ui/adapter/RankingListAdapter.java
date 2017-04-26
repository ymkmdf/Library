package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library.api.model.Bookrack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyan on 17/3/12.
 */

public class RankingListAdapter extends BaseAdapter<RankingListAdapter.DataHolder>{

    public RankingListAdapter(Context context, OnRecyclerViewItemClickListener onItemClickListener) {
        super(context, onItemClickListener);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                v = View.inflate(mContext, R.layout.layout_boutique_item ,null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new PurchaseViewHolder(v);
                break;

            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        final DataHolder dataHolder = mDatas.get(position);
        final int itemViewType = dataHolder.getType();
        switch (itemViewType){
            case 0:
                PurchaseViewHolder viewHolder = (PurchaseViewHolder) holder;
                viewHolder.bind(mContext,dataHolder,position);
                break;

            default:
                break;
        }
    }

    public void addBook(Bookrack b){ //购买
        final DataHolder data = new DataHolder(0);
        data.setBookrack(b);
        mDatas.add(data);
        notifyDataSetChanged();
    }




    public class DataHolder extends BaseDataHolder{

        public DataHolder(int type) {
            super(type);
        }

        public String str;
        public Bookrack bookrack;

        public Bookrack getBookrack() {
            return bookrack;
        }

        public void setBookrack(Bookrack bookrack) {
            this.bookrack = bookrack;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }


    public class PurchaseViewHolder extends BaseViewHolder{

        public PurchaseViewHolder(View view) {
            super(view,mOnItemClickListener);
            ButterKnife.bind(this,view);
        }
        @BindView(R.id.image)
        ImageView mImage;
        @BindView(R.id.name)
        TextView mName;
        public void bind(Context context,DataHolder dataHolder,int position){
            mImage.setBackgroundResource(dataHolder.getBookrack().getImage());
            mName.setText(dataHolder.getBookrack().getName());
        }

    }

}
