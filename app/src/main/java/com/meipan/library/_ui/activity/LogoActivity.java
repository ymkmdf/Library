package com.meipan.library._ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.meipan.library.R;

/**
 * Created by gaoyan on 17/2/25.
 */

public class LogoActivity extends BaseActivity {

    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mHandler.removeMessages(1);
                    if (true) {
                        startActivity(new Intent(LogoActivity.this, MainActivity.class));
                        finish();
                    }else {
                        startActivity(new Intent(LogoActivity.this, WelcomeActivity.class));
                        finish();
                    }
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mHandler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
