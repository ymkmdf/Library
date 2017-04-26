package com.meipan.library._ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;
import com.meipan.library._ui.activity.BaseActivity;
import com.meipan.library._ui.adapter.GridSpacingItemDecoration;
import com.meipan.library._ui.adapter.ItemDivider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by gaoyan on 17/2/25.
 */

public class BaseFragment extends Fragment{
    public BaseActivity mActivity;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onEvent(Object event){}


    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }

    private CompositeSubscription mCompositeSubscription;

    public void onUnsubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
//        if (mCompositeSubscription == null) {
        mCompositeSubscription = new CompositeSubscription();
//        }
        mCompositeSubscription.add(subscription);
    }

    public void initRecyclerViewAsHeaderGridView(RecyclerView recyclerView, int spanCount, RecyclerView.OnScrollListener loadMoreListener) {
        initRecyclerViewAsGridView(recyclerView, true, spanCount, loadMoreListener);
    }

    public void initRecyclerViewAsGridView(RecyclerView recyclerView, int spanCount, RecyclerView.OnScrollListener loadMoreListener) {
        initRecyclerViewAsGridView(recyclerView, false, spanCount, loadMoreListener);
    }

    public void initRecyclerViewAsGridView(RecyclerView recyclerView, boolean hasHeader, int spanCount, RecyclerView.OnScrollListener loadMoreListener) {
        final GridLayoutManager mLayoutManager = new GridLayoutManager(mActivity, spanCount);
        mLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        if (loadMoreListener != null) {
            recyclerView.addOnScrollListener(loadMoreListener);
        }
        if (!hasHeader) {
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, getResources().getDimensionPixelSize(R.dimen.space), true));
        }
    }

    public void initRecyclerViewAsGridView(RecyclerView recyclerView, int spanCount) {
        initRecyclerViewAsGridView(recyclerView, spanCount, null);
    }

    public void initRecyclerViewAsListView(RecyclerView recyclerView) {
        initRecyclerViewAsListView(recyclerView, true, null);
    }

    public void initRecyclerViewAsListView(RecyclerView recyclerView, boolean hasDivider) {
        initRecyclerViewAsListView(recyclerView, hasDivider, null);
    }

    public void initRecyclerViewAsListView(RecyclerView recyclerView, boolean hasDivider, RecyclerView.OnScrollListener loadMoreListener) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        if (hasDivider) {
            recyclerView.addItemDecoration(new ItemDivider(mActivity, R.drawable.item_divider));
        }
        if (loadMoreListener != null) {
            recyclerView.addOnScrollListener(loadMoreListener);
        }
    }
}
