package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.meipan.library.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by GaoYan on 2016/12/10.
 */

public class FindBookAdapter extends RecyclerView.Adapter<BaseViewHolder> implements OnRecyclerViewItemClickListener{

    private Context mContext;
    private final List<FindBookDataHolder> mDatas=new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public FindBookAdapter(Context context,OnRecyclerViewItemClickListener onItemClickListener){
            mContext=context;
            mOnItemClickListener=onItemClickListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                v = View.inflate(mContext, R.layout.item_find_book ,null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new FindBookViewHolder(v);
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
        final FindBookDataHolder dataHolder = mDatas.get(position);
        final int itemViewType = dataHolder.getType();
        switch (itemViewType){
            case 0:
                FindBookViewHolder menuHeaderViewHolder = (FindBookViewHolder) holder;
                menuHeaderViewHolder.bind(mContext,dataHolder,position);
                break;
            case 1:
//                BookRecommendViewHolder bookRecommendViewHolder = (BookRecommendViewHolder) holder;
//                bookRecommendViewHolder.bind(mContext,dataHolder,position);
                break;
            default:
                break;
        }
    }


    @Override
    public int getItemCount() { return mDatas.size(); }

    @Override
    public int getItemViewType(int position) { return mDatas.get(position).getType(); }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void addFindBook(String str){
        final FindBookDataHolder data = new FindBookDataHolder(0);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void clear(){
        mDatas.clear();
        notifyDataSetChanged();
    }

    public class FindBookDataHolder extends BaseDataHolder{
        public FindBookDataHolder(int type){ super(type);}
        public String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

    public class BookRecommendViewHolder extends BaseViewHolder{

        public BookRecommendViewHolder(View view) {
            super(view,mOnItemClickListener);
            ButterKnife.bind(this,view);
        }

        public void bind(Context context, FindBookDataHolder dataHolder, int position){
        }

    }

    public class FindBookViewHolder extends BaseViewHolder{

//        @Bind(R.id.item)
//        LinearLayout mItem;
        public FindBookViewHolder(View view){
            super(view,mOnItemClickListener);
            ButterKnife.bind(this,view);
        }

        public void bind(Context context, FindBookDataHolder dataHolder, int position){
        }
//        @OnClick(R.id.item)
//        public void onItem(View view){
//            mContext.startActivity(new Intent(mContext, YueDuActivity.class));
        }

}
