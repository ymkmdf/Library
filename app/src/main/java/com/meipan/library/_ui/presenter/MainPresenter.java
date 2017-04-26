package com.meipan.library._ui.presenter;

import com.meipan.library._ui.dataview.MainView;
import com.meipan.library.api.model.Model;
import com.meipan.library.net.ApiCallback;

/**
 * Created by gaoyan on 17/2/25.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }


    public void loadCircle() {

        addSubscription(mApiService.getCircle(), new ApiCallback<Model>() {
            @Override
            public void onSuccess(Model model) {
                mMvpView.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mMvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
