package com.meipan.library._ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.meipan.library.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    @BindView(R.id.start_button)
    TextView mStartButton;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private List<View> mViews;
    private ImageView[] mDots;
    private int mCurrentIndex;
    private int mPage = 0;

    private static final int[] pics = {R.drawable.image001,R.drawable.image002,R.drawable.image003,R.drawable.image004};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        mViews = new ArrayList<View>();
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        for (int i = 0; i< pics.length; i++){
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);
            mViews.add(iv);
        }

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new ViewPagerAdapter(mViews);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(this);
        initDots();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void initDots(){
        LinearLayout allCircle = (LinearLayout) findViewById(R.id.all_circle);
        mDots = new ImageView[pics.length];
        for (int i=0; i <pics.length;i++){
            mDots[i] = (ImageView) allCircle.getChildAt(i);
            mDots[i].setEnabled(true);
            mDots[i].setOnClickListener(this);
            mDots[i].setTag(i);
        }
        mCurrentIndex = 0;
        mDots[mCurrentIndex].setEnabled(false);
    }

    private void setCurDot(int position){
        if (position < 0 || position > pics.length -1 || mCurrentIndex == position){
            return;
        }
        mDots[position].setEnabled(false);
        mDots[mCurrentIndex].setEnabled(true);
        mCurrentIndex = position;
    }

    private void setCurView(int position){
        if (position < 0|| position >= pics.length){
            return;
        }
        mViewPager.setCurrentItem(position);
    }


    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurDot(position);
        mPage = position;
        if (position == pics.length -1){
            mStartButton.setVisibility(View.VISIBLE);
            mStartButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                    finish();
                }
            });
        } else {
            mStartButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class ViewPagerAdapter extends PagerAdapter{
        private List<View> views;
        public ViewPagerAdapter(List<View> views){this.views = views;}

        @Override
        public int getCount() {
            if (views != null){
                return views.size();
            }
            return 0;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(views.get(position));
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(views.get(position), 0);
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
            //super.restoreState(state, loader);
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(ViewGroup container) {
            //
        }
    }
}
