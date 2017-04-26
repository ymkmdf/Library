package com.meipan.library._ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.meipan.library.R;
import com.meipan.library._ui.activity.BookdescriptionActivity;
import com.meipan.library._ui.activity.BoutiqueActivity;
import com.meipan.library.api.model.Banner;
import com.meipan.library.utils.DisplayUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaoyan on 17/3/4.
 * 精选
 */
public class BoutiqueAdapter extends RecyclerView.Adapter<BaseViewHolder> implements OnRecyclerViewItemClickListener {

    private static final int INTERVAL = 3 * 1000;
    private Context mContext;
    private List<BoutiqueDataHolder> mDatas = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnItemClickListener;
    private BoutiqueDataHolder mHeaderDataHolder;
    private HeaderViewHolder headerViewHolder;
    private int mCounter = 0;

    public BoutiqueAdapter(Context context, OnRecyclerViewItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void initHeader() {
        mDatas.clear();
        mHeaderDataHolder = new BoutiqueDataHolder(0);
        mDatas.add(mHeaderDataHolder);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        if (mHeaderDataHolder != null) {
            mDatas.add(mHeaderDataHolder);
        }
        notifyDataSetChanged();
    }

    public void setBanners(List<Banner> banners) {
        mHeaderDataHolder = new BoutiqueDataHolder(0);
        mHeaderDataHolder.setBanners(banners);
        mDatas.add(mHeaderDataHolder);
        notifyDataSetChanged();
    }

    public void addClassification(String str) {
        final BoutiqueDataHolder data = new BoutiqueDataHolder(3);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();
        addDivder("");
    }

    public void addBoutique(String str) {
        final BoutiqueDataHolder data = new BoutiqueDataHolder(1);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void addAD(String str) {
        final BoutiqueDataHolder data = new BoutiqueDataHolder(2);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();

    }

    public void addDivder(String str) {
        final BoutiqueDataHolder data = new BoutiqueDataHolder(4);
        data.setStr(str);
        mDatas.add(data);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getType();
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                v = View.inflate(mContext, R.layout.layout_boutique_header, null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = headerViewHolder = new HeaderViewHolder(v);
                break;
            case 1:
                v = View.inflate(mContext, R.layout.layout_boutique_item, null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new BoutiqueViewHolder(v);
                break;
            case 2:
                v = View.inflate(mContext, R.layout.layout_boutique_aditem, null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new BoutiqueADViewHolder(v);
                break;
            case 3:
                v = View.inflate(mContext, R.layout.layout_boutique_classification_item, null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                viewHolder = new BoutiqueClassification(v);
                break;
            case 4:
                v = View.inflate(mContext, R.layout.layout_bg_diviger, null);
                v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, DisplayUtils.dpToPxInt(mContext, 5)));
                viewHolder = new Diviger5(v);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        final BoutiqueDataHolder dataHolder = mDatas.get(position);
        final int itemViewType = dataHolder.getType();
        switch (itemViewType) {
            case 0:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.bind(mContext, dataHolder, position);
                break;
            case 1:
                BoutiqueViewHolder boutiqueViewHolder = (BoutiqueViewHolder) holder;
                boutiqueViewHolder.bind(mContext, dataHolder, position);
                break;
            case 2:
                BoutiqueADViewHolder boutiqueADViewHolder = (BoutiqueADViewHolder) holder;
                boutiqueADViewHolder.bind(mContext, dataHolder, position);
                break;
            case 3:
                BoutiqueClassification boutiqueClassification = (BoutiqueClassification) holder;
                boutiqueClassification.bind(mContext, dataHolder, position);
                break;
            case 4:
                Diviger5 diviger5 = (Diviger5) holder;
                diviger5.bind(mContext, dataHolder, position);
                break;
            default:
                break;
        }
    }

    public class BoutiqueDataHolder extends BaseDataHolder {

        public BoutiqueDataHolder(int type) {
            super(type);
        }

        private List<Banner> banners;
        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(List<Banner> banners) {
            this.banners = banners;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void removeCallBacksAndMessage() {
        headerViewHolder.removeCallbackAndMessage();
    }


    //banner
    public class HeaderViewHolder extends BaseViewHolder {
        public HeaderViewHolder(View view) {
            super(view, mOnItemClickListener);
//            mImageAdapter = new ImagePagerAdapter(mContext);
//            mImageAdapter.setOnItemClickListener(mItemClickListener);
//            ButterKnife.bind(this, view);
//            mImagePager.setNoScroll(false);

        }

        private final View.OnClickListener mItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImagePagerAdapter.PageInfo page = (ImagePagerAdapter.PageInfo) v.getTag();

            }
        };

        public void bind(Context context, BoutiqueDataHolder dataHolder, int position) {
        }

        public void removeCallbackAndMessage() {
//            mIntervalHandler.removeCallbacksAndMessages(null);
        }

    }

    //精品书籍推荐
    public class BoutiqueViewHolder extends BaseViewHolder {

        @BindView(R.id.item)
        LinearLayout mItem;

        public BoutiqueViewHolder(View view) {
            super(view, mOnItemClickListener);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, BoutiqueDataHolder dataHolder, int position) {
        }

        @OnClick(R.id.item)
        public void onItem(View view) {
            mContext.startActivity(new Intent(mContext, BookdescriptionActivity.class));
        }

    }

    //广告推广
    public class BoutiqueADViewHolder extends BaseViewHolder {
        public BoutiqueADViewHolder(View view) {
            super(view, mOnItemClickListener);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, BoutiqueDataHolder dataHolder, int position) {

        }
    }

    //分类
    public class BoutiqueClassification extends BaseViewHolder {
        @BindView(R.id.ranking_list)
        LinearLayout mRankingList;

        public BoutiqueClassification(View view) {
            super(view, mOnItemClickListener);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, BoutiqueDataHolder dataHolder, int position) {

        }

        @OnClick({R.id.jing, R.id.shiji, R.id.zilei, R.id.jilei})
        public void onRankingList(View view) {
            Intent intent = new Intent(mContext, BoutiqueActivity.class);
            switch (view.getId()) {
                case R.id.jing:
                    intent.putExtra("type", 0);
                    break;
                case R.id.shiji:
                    intent.putExtra("type", 1);
                    break;
                case R.id.zilei:
                    intent.putExtra("type", 2);
                    break;
                case R.id.jilei:
                    intent.putExtra("type", 3);

                    break;
            }
            mContext.startActivity(intent);
        }
    }

    //分割线
    public class Diviger5 extends BaseViewHolder {

        public Diviger5(View view) {
            super(view, mOnItemClickListener);
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, BoutiqueDataHolder dataHolder, int position) {

        }
    }


}
