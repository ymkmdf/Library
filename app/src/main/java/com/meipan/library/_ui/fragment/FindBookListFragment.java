package com.meipan.library._ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;
import com.meipan.library._ui.adapter.CommentAreaAdapter;
import com.meipan.library._ui.adapter.FindBookAdapter;
import com.meipan.library.api.model.Bookrack;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GaoYan on 2016/12/10.
 */

public class FindBookListFragment extends BaseFragment {
    private static final String TAG = FindBookListFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private FindBookAdapter mAdapter;
    private CommentAreaAdapter mCAdapter;
    private int mPage = 0;
    public static final int FIND=0; //寻书
    public static final int COMMCENT=1; //书评
    public static FindBookListFragment newInstance(int type){
        FindBookListFragment fragment = new FindBookListFragment();
        final Bundle args = new Bundle();
        args.putInt("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        switch (getArguments().getInt("type")){
            case FIND:
                mAdapter = new FindBookAdapter(context,null);
                break;
            case COMMCENT:
                mCAdapter = new CommentAreaAdapter(context,null);
                break;
        }

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
        switch (getArguments().getInt("type")){
            case FIND:
                mRecyclerView.setAdapter(mAdapter);
                break;
            case COMMCENT:
                mRecyclerView.setAdapter(mCAdapter);
                break;
        }
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
        switch (getArguments().getInt("type")){
            case FIND:
                if (mPage == 0) {
                    mAdapter.clear();
                    mAdapter.addFindBook("123");
                }
                for (int i = 0 ;i < 10; i++){
                    mAdapter.addFindBook("qwe");
                }
                mPage=mPage+1;
                break;
            case COMMCENT:
                if (mPage == 0) {
                    mCAdapter.clear();
                }

                for (int i = 0 ;i < 10; i++){
                    mCAdapter.addComment("qwe");
                }
                mPage=mPage+1;
                break;
        }

    }
}
