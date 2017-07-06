package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.meipan.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 书籍介绍
 */
public class BookdescriptionActivity extends BaseActivity {


    @BindView(R.id.back_button)
    ImageView mBackButton;
    @BindView(R.id.right_button)
    ImageView mRightButton;
    @BindView(R.id.right)
    LinearLayout right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdescription);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }


    @OnClick({R.id.back_button, R.id.right_button, R.id.right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                onBackPressed();
                break;
            case R.id.right_button:
                break;
            case R.id.right:
                break;
        }
    }
}
