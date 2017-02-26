package com.meipan.library._ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.meipan.library._ui.presenter.BasePresenter;

/**
 * Created by gaoyan on 17/2/25.
 */

public abstract class MActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
