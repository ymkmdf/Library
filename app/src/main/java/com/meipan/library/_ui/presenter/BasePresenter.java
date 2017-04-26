package com.meipan.library._ui.presenter;

import com.meipan.library.api.ApiNetWork;
import com.meipan.library.net.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by gaoyan on 17/2/25.
 */

public class BasePresenter<V> {

    public V mMvpView;
    protected ApiNetWork mApiService;
    private CompositeSubscription mCompositeSubscription;

    public void attachView(V mvpView){
        this.mMvpView = mvpView;
        mApiService = AppClient.getInstance().getApiService();
    }

    public void detachView(){
        this.mMvpView = null;
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

}
