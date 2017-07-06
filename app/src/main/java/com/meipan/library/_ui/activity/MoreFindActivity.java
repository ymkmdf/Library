package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library._ui.fragment.FindBookListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreFindActivity extends BaseActivity {
    @BindView(R.id.back_button)
    ImageView mBackButton;
    @BindView(R.id.right_button)
    ImageView mRightButton;
    @BindView(R.id.title_text)
    TextView mTitleText;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ButterKnife.bind(this);

        mRightButton.setVisibility(View.VISIBLE);
        title = getIntent().getStringExtra("title");
        mTitleText.setText(title);

        replace(R.id.content_frame, FindBookListFragment.newInstance(getIntent().getIntExtra("type",0)));
    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }
}
