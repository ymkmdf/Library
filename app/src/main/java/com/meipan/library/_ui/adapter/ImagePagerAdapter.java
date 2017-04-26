package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.meipan.library.R;
import com.meipan.library.utils.ImageUtils;
import com.meipan.library.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaio on 2016/5/21.
 */
public class ImagePagerAdapter extends PagerAdapter {
    public static class PageInfo{
        public String getImageUrl(){return imageUrl;}
        public void setImageUrl(String imageUrl){this.imageUrl = imageUrl;}
        public PageInfo(String imageUrl){this.imageUrl = imageUrl;}
        public void setTag(Object tag){this.tag = tag;}
        public Object getTag(){return tag;}

        Object tag;
        String imageUrl;
    }

    final List<PageInfo> PAGES = new ArrayList<>();

    private View.OnClickListener mItemClickListener;
    Context mContext;
    LayoutInflater mLayoutInflater;
    public ImagePagerAdapter(Context context){
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() { return ListUtils.getSize(PAGES);}

    @Override
    public boolean isViewFromObject(View view, Object object) {return view == object;}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = mLayoutInflater.inflate(R.layout.layout_image,container,false);
        final PageInfo info = PAGES.get(position);
        final ImageView image = (ImageView) v.findViewById(R.id.image);
//        ImageUtils.setImageByUrl(image, info.getImageUrl());
        container.addView(v);
        image.setTag(info);
        image.setOnClickListener(mItemClickListener);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setOnItemClickListener(View.OnClickListener listener){
        mItemClickListener = listener;
    }

    public void addPage(PageInfo page){
        PAGES.add(page);
        notifyDataSetChanged();
    }

    public void clearPage(){
        PAGES.clear();
        notifyDataSetChanged();
    }
}
