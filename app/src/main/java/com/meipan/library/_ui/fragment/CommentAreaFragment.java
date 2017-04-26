package com.meipan.library._ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;
import com.meipan.library._ui.adapter.BaseAdapter;
import com.meipan.library._ui.adapter.CommentAreaAdapter;
import com.meipan.library.api.model.Bookrack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyan on 17/3/27.
 */

public class CommentAreaFragment extends BaseFragment{

    private static final String TAG = FindBookListFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private BaseAdapter mAdapter;
    private int mPage = 0;

    public CommentAreaFragment newInstance(){
        CommentAreaFragment fragment = new CommentAreaFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAdapter = new CommentAreaAdapter(context,null);
        initRequester();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_xrecycle_view,container,false);
        ButterKnife.bind(this,view);
        initRecyclerViewAsListView(mRecyclerView,false,null);
        mRecyclerView.setHasFixedSize(true);
        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setAdapter(mAdapter);
        refresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind(this);
    }

    @Override
    public void onEvent(Object event) {
        super.onEvent(event);
    }

    public void initRequester(){

    }

    public void refreshPage(){
        refresh();
    }

    public void refresh(){
        mPage = 0;
        loadPage();
    }

    public void loadPage(){
        if (mPage == 0) {
            mAdapter.clear();
//            mRecyclerView.setPullRefreshEnabled(false);
//            mAdapter.addFindBook("123");
        } else {
//            mRecyclerView.setLoadingMoreEnabled(false);
        }

        for (int i = 0 ;i < 10; i++){
            Bookrack bookrack = new Bookrack();
//            mAdapter.addFindBook("qwe");
        }
        mPage=mPage+1;
    }
}
