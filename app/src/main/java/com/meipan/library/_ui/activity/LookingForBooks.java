package com.meipan.library._ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.meipan.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LookingForBooks extends AppCompatActivity {
    @BindView(R.id.back_button)
    ImageView mBackButton;
    @BindView(R.id.right_button)
    ImageView mRightButton;
    @BindView(R.id.title_text)
    TextView mTitleText;
    @BindView(R.id.book_name)
    EditText mBookName;
    @BindView(R.id.book_content)
    EditText mBookContent;
    @BindView(R.id.button)
    TextView mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_for_books);
        ButterKnife.bind(this);
        mTitleText.setText("寻书");
        initRequester();
        initView();
    }

    public void initView(){
        mBookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                if (!TextUtils.isEmpty(str.trim())){
                    mButton.setClickable(true);
                    mButton.setBackgroundResource(R.drawable.app_fillet_background);
                } else {
                    mButton.setClickable(false);
                    mButton.setBackgroundResource(R.drawable.gray_fillet_background);
                }
            }
        });
    }

    public void initRequester(){

    }

    @OnClick(R.id.button)
    public void onButton(View view){
        finish();
    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }

}
