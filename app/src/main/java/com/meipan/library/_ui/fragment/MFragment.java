package com.meipan.library._ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.meipan.library._ui.presenter.BasePresenter;

/**
 * Created by gaoyan on 17/2/25.
 */

public abstract class MFragment<P extends BasePresenter> extends BaseFragment{
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }


}
