package com.meipan.library._ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library._ui.activity.YueDuActivity;
import com.meipan.library.api.model.Bookrack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaoyan on 17/3/4.
 */
public class BookrackAdapter extends RecyclerView.Adapter<BaseViewHolder> implements OnRecyclerViewItemClickListener {
    private  Context mContext;
    private final List<BookrackDataHolder> mDatas = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public BookrackAdapter(Context context,OnRecyclerViewItemClickListener onItemClickListener){
        mContext = context;
        mOnItemClickListener = onItemClickListener;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                v = View.inflate(mContext,R.layout.item_bookrack ,null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new BookrackViewHolder(v);
                break;
            case 1:
                v = View.inflate(mContext,R.layout.layout_recommend,null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new BookRecommendViewHolder(v);
            default:
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        final BookrackDataHolder dataHolder = mDatas.get(position);
        final int itemViewType = dataHolder.getType();
        switch (itemViewType){
            case 0:
                BookrackViewHolder menuHeaderViewHolder = (BookrackViewHolder) holder;
                menuHeaderViewHolder.bind(mContext,dataHolder,position);
                break;
            case 1:
                BookRecommendViewHolder bookRecommendViewHolder = (BookRecommendViewHolder) holder;
                bookRecommendViewHolder.bind(mContext,dataHolder,position);
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


    public void addBookrack(Bookrack bookrack){
        final BookrackDataHolder data = new BookrackDataHolder(0);
        data.setBookrack(bookrack);
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void addRecommend(String str){
        final BookrackDataHolder data = new BookrackDataHolder(1);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void clear(){
        mDatas.clear();
        notifyDataSetChanged();
    }

    public class BookrackDataHolder extends BaseDataHolder{
        public BookrackDataHolder(int type){ super(type);}
        public Bookrack bookrack;
        public String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Bookrack getBookrack() {
            return bookrack;
        }

        public void setBookrack(Bookrack bookrack) {
            this.bookrack = bookrack;
        }
    }

    public class BookRecommendViewHolder extends BaseViewHolder{

        public BookRecommendViewHolder(View view) {
            super(view,mOnItemClickListener);
            ButterKnife.bind(this,view);
        }

        public void bind(Context context, BookrackDataHolder dataHolder, int position){
        }

    }

    public class BookrackViewHolder extends BaseViewHolder{

        @BindView(R.id.item)
        LinearLayout mItem;
        @BindView(R.id.item_imageview)
        ImageView mImage;
        @BindView(R.id.book_name)
        TextView mName;
        public BookrackViewHolder(View view){
            super(view,mOnItemClickListener);
            ButterKnife.bind(this,view);
        }

        public void bind(Context context, BookrackDataHolder dataHolder, int position){
            Bookrack bookrack = dataHolder.getBookrack();
            mImage.setBackgroundResource(bookrack.getImage());
            mName.setText(bookrack.getName());
            mItem.setTag(position);
        }
        @OnClick(R.id.item)
        public void onItem(View view){
            int p= (int) view.getTag();
            Intent intent = new Intent(mContext, YueDuActivity.class);
            intent.putExtra("book",p);
            mContext.startActivity(intent);
        }


    }
}
