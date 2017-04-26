package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meipan.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.right_button)
    ImageView rightButton;
    @BindView(R.id.right)
    LinearLayout right;
    @BindView(R.id.title_text)
    TextView mTitleText;
    @BindView(R.id.title_layout)
    LinearLayout titleLayout;
    @BindView(R.id.title_color)
    LinearLayout titleColor;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    @BindView(R.id.wechat_login)
    ImageView wechatLogin;
    @BindView(R.id.blog_login)
    ImageView blogLogin;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.button)
    TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mTitleText.setText("登陆");

    }

    @OnClick({R.id.back_button, R.id.qq_login, R.id.wechat_login, R.id.blog_login, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                onBackPressed();
                break;
            case R.id.blog_login:
                break;
            case R.id.wechat_login:
                break;
            case R.id.qq_login:
                break;
            case R.id.button:
                break;
        }
    }
}

