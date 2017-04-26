package com.meipan.library._ui.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.meipan.library.Constants;
import com.meipan.library.R;
import com.meipan.library.utils.DataCleanManager;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 空白页
 */
public class SettingActivity extends BaseActivity {
    private static final String TAG = SettingActivity.class.getSimpleName();
    private final File mCachePath = new File(Constants.IMAGE_CACHE_ROOT);
    @BindView(R.id.title_text)
    TextView mTitleText;
    @BindView(R.id.setting_version)
    TextView mSettingVersion;
    @BindView(R.id.cache)
    TextView mCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        initView();
    }

    public void initView(){
        mTitleText.setText("设置");

        try {
            PackageInfo mPackageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            mSettingVersion.setText("Version  " + mPackageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        final String size = DataCleanManager.getCacheSize(mCachePath);
        mCache.setText(size);
    }

    @OnClick(R.id.back_button)
    public void onBackButton(View view){
        onBackPressed();
    }
}
