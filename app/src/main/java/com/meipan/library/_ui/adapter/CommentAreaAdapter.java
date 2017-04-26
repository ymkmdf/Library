package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;

/**
 * Created by gaoyan on 17/3/27.
 */

public class CommentAreaAdapter extends BaseAdapter<CommentAreaAdapter.DataHolder> {


    public CommentAreaAdapter(Context context, OnRecyclerViewItemClickListener onItemClickListener) {
        super(context, onItemClickListener);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                v = View.inflate(mContext, R.layout.layout_comment_item ,null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new CommentViewHolder(v);
                break;
//            case 1:
//                v = View.inflate(mContext,R.layout.layout_recommend,null);
//                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
//                viewHolder = new BookRecommendViewHolder(v);
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
                CommentViewHolder  commentViewHolder = (CommentViewHolder) holder;
                commentViewHolder.bind(mContext,dataHolder,position);
                break;
            case 1:
//                BookRecommendViewHolder bookRecommendViewHolder = (BookRecommendViewHolder) holder;
//                bookRecommendViewHolder.bind(mContext,dataHolder,position);
                break;
            default:
                break;
        }
    }

    public void addComment(String str){
        DataHolder data = new DataHolder(0);
        mDatas.add(data);
        notifyDataSetChanged();

    }



    public class DataHolder extends BaseDataHolder{

        public DataHolder(int type) {
            super(type);
        }
    }



    public class CommentViewHolder extends BaseViewHolder{

        public CommentViewHolder(View view) {
            super(view, mOnItemClickListener);
        }

        public void bind(Context context,DataHolder data,int postition){

        }
    }
}
