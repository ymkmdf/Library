package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library._ui.dataview.RankingListView;
import com.meipan.library._ui.fragment.RankingListFragment;
import com.meipan.library._ui.presenter.RankingListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 排行榜
 */
public class RankingListActivity extends MActivity<RankingListPresenter> implements RankingListView {

    @BindView(R.id.title_text)
    TextView mTitleText;
    @BindView(R.id.purchase)
    TextView mPurchase;
    @BindView(R.id.read)
    TextView mRead;
    @BindView(R.id.click)
    TextView mClick;

    @Override
    protected RankingListPresenter createPresenter() {
        return new RankingListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_list);
        ButterKnife.bind(this);
        mTitleText.setText("排行榜");
        replace(R.id.comment, RankingListFragment.newInstance(0));
        mPurchase.setTextColor(getResources().getColor(R.color.app_theme));
        mRead.setTextColor(getResources().getColor(R.color.black_light));
        mClick.setTextColor(getResources().getColor(R.color.black_light));
    }


    @OnClick({R.id.back_button, R.id.purchase, R.id.read, R.id.click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                onBackPressed();
                break;
            case R.id.purchase:
                replace(R.id.comment, RankingListFragment.newInstance(0));
                mPurchase.setTextColor(getResources().getColor(R.color.app_theme));
                mRead.setTextColor(getResources().getColor(R.color.black_light));
                mClick.setTextColor(getResources().getColor(R.color.black_light));
                break;
            case R.id.read:
                replace(R.id.comment, RankingListFragment.newInstance(1));
                mPurchase.setTextColor(getResources().getColor(R.color.black_light));
                mRead.setTextColor(getResources().getColor(R.color.app_theme));
                mClick.setTextColor(getResources().getColor(R.color.black_light));
                break;
            case R.id.click:
                replace(R.id.comment, RankingListFragment.newInstance(2));
                mPurchase.setTextColor(getResources().getColor(R.color.black_light));
                mRead.setTextColor(getResources().getColor(R.color.black_light));
                mClick.setTextColor(getResources().getColor(R.color.app_theme));
                break;
        }
    }
}
