package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.meipan.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 暂时代替空白页
 */
public class nullActivity extends AppCompatActivity {

    String title;
    @BindView(R.id.title_text)
    TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null);
        ButterKnife.bind(this);
        title = getIntent().getStringExtra("title");
        mTitleText.setText(title);
    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }
}
