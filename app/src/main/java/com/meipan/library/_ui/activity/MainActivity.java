package com.meipan.library._ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.meipan.library.R;
import com.meipan.library._ui.dataview.MainView;
import com.meipan.library._ui.presenter.BasePresenter;
import com.meipan.library._ui.presenter.MainPresenter;

public class MainActivity extends MActivity<MainPresenter> implements MainView{

    public final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
