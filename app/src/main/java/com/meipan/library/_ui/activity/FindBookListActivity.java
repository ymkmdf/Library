package com.meipan.library._ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meipan.library.R;
import com.meipan.library._ui.fragment.FindBookListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 寻书列表
 */
public class FindBookListActivity extends BaseActivity {
    @BindView(R.id.back_button)
    ImageView mBackButton;
    @BindView(R.id.right_button)
    ImageView mRightButton;
    @BindView(R.id.title_text)
    TextView mTitleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        mTitleText.setText("寻书列表");
        mRightButton.setVisibility(View.VISIBLE);

        replace(R.id.content_frame, FindBookListFragment.newInstance(0));
    }
    @OnClick(R.id.right_button)
    public void onRightButton(View view){
        startActivity(new Intent(this,LookingForBooks.class));
    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }
}
