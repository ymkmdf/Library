package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meipan.library.R;
import com.meipan.library._ui.dataview.MainView;
import com.meipan.library._ui.fragment.BookrackFragment;
import com.meipan.library._ui.fragment.BoutiqueFragment;
import com.meipan.library._ui.fragment.FoundFragment;
import com.meipan.library._ui.fragment.MeFramgnet;
import com.meipan.library._ui.presenter.MainPresenter;
import com.meipan.library.api.model.Model;
import com.meipan.library.messager.ActionEvent;
import com.meipan.library.widget.CustomViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MActivity<MainPresenter> implements MainView {

    public final static String TAG = "MainActivity";
    @BindView(R.id.viewpager)
    CustomViewPager mViewPager;
    @BindView(R.id.bookshelf)
    TextView mBookshelf;
    @BindView(R.id.boutique)
    TextView mBoutique;
    @BindView(R.id.find)
    TextView mFind;
    @BindView(R.id.my)
    TextView mMy;
    @BindView(R.id.title_text)
    TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        initView();
    }

    @OnClick(R.id.bookshelf)
    public void onBookshelf(View view){
        mViewPager.setCurrentItem(0);
//        mvpPresenter.loadCircle();
        EventBus.getDefault().post(new ActionEvent("abc111"));
    }
    @OnClick(R.id.boutique)
    public void onBoutique(View view){
        mViewPager.setCurrentItem(1);
    }
    @OnClick(R.id.find)
    public void onFind(View view){
        mViewPager.setCurrentItem(2);
    }
    @OnClick(R.id.my)
    public void onClick(View view){
        mViewPager.setCurrentItem(3);
    }

    private void initView() {
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                updataButton(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        updataButton(0);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    public void updataButton(int i){
        mBookshelf.setTextColor(i == 0 ? getResources().getColor(R.color.white):(getResources().getColor(R.color.text_black)));
        mBookshelf.setBackgroundColor(i == 0 ?getResources().getColor(R.color.app_theme) :getResources().getColor(R.color.white));
        mBoutique.setTextColor(i == 1 ? getResources().getColor(R.color.white):(getResources().getColor(R.color.text_black)));
        mBoutique.setBackgroundColor(i == 1 ?getResources().getColor(R.color.app_theme) :getResources().getColor(R.color.white));
        mFind.setTextColor(i == 2 ? getResources().getColor(R.color.white):(getResources().getColor(R.color.text_black)));
        mFind.setBackgroundColor(i == 2 ?getResources().getColor(R.color.app_theme) :getResources().getColor(R.color.white));
        mMy.setTextColor(i == 3 ? getResources().getColor(R.color.white):(getResources().getColor(R.color.text_black)));
        mMy.setBackgroundColor(i == 3 ?getResources().getColor(R.color.app_theme) :getResources().getColor(R.color.white));
        mTitleText.setText(i == 0 ? getResources().getString(R.string.bookshelf) : i == 1 ?
                getResources().getString(R.string.boutique) : i == 2 ? getResources().getString(R.string.find) : getResources().getString(R.string.my)
        );
    }

    @Override
    public void getDataSuccess(Model model) {
        Log.i("TAGGG","成功了");
    }

    @Override
    public void getDataFail(String str) {

    }

    public class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fm = null;
            switch (position) {
                case 0:
                    fm = new BookrackFragment();
                    break;
                case 1:
                    fm = new BoutiqueFragment();
                    break;
                case 2:
                    fm = new FoundFragment();
                    break;
                case 3:
                    fm = new MeFramgnet();
                    break;
                default:
                    break;
            }
            return fm;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @Subscribe
    public void onEvent(Object event) {
//        super.onEvent(event);
        ActionEvent str = (ActionEvent) event;
        if (str.getAction().equals("abc111")){
            Toast.makeText(this,"str",Toast.LENGTH_SHORT).show();
        }

    }
}
