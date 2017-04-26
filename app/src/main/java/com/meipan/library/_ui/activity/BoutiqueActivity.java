package com.meipan.library._ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library._ui.dataview.BoutiqueView;
import com.meipan.library._ui.fragment.ClassificationFragment;
import com.meipan.library._ui.presenter.BoutiquePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoutiqueActivity extends MActivity<BoutiquePresenter> implements BoutiqueView {

    @BindView(R.id.title_text)
    TextView mTitleText;
    int mType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
        ButterKnife.bind(this);
        mType = getIntent().getIntExtra("type",0);
        mTitleText.setText(setTitle());
        replace(R.id.comment, ClassificationFragment.newInstance(mType));
    }

    @Override
    protected BoutiquePresenter createPresenter() {
        return new BoutiquePresenter(this);
    }

    public String setTitle(){
        switch (mType){
            case 0:
                return "精品—经部";
            case 1:
                return "精品—史部";
            case 2:
                return "精品—子部";
            case 3:
                return "精品—集部";
            default:
                return "精品—经部";
        }
    }

}
