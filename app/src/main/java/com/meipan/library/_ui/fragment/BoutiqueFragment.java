package com.meipan.library._ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.meipan.library.R;
import com.meipan.library._ui.adapter.BoutiqueAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 精选
 */
public class BoutiqueFragment extends BaseFragment {



    @BindView(R.id.recycler_view)
    RecyclerView mRecycleView;
    BoutiqueAdapter mAdapter;
    int mPage;

    private RecyclerView.LayoutManager layoutManager;

    public static BoutiqueFragment newInstance(){
        BoutiqueFragment fragment = new BoutiqueFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAdapter = new BoutiqueAdapter(getActivity(),null);
        initRequester();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boutique, container, false);
        ButterKnife.bind(this, view);
        initRecyclerViewAsListView(mRecycleView, false, null);
        mRecycleView.setHasFixedSize(true);
        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycleView.setAdapter(mAdapter);
        refresh();

    }

    public void refresh(){
        mAdapter.initHeader();
        mPage = 0;
        loadPage();
    }

    public void loadPage(){
        if (mPage == 0){
            mAdapter.clear();
            mAdapter.addClassification("");
        }

        for (int i=0;i<3;i++){
            mAdapter.addBoutique("");
        }
        mAdapter.addAD("");
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }


    public void initRequester(){

    }
}
