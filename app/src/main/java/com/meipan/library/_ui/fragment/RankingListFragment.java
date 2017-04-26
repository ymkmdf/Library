package com.meipan.library._ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;
import com.meipan.library._ui.adapter.RankingListAdapter;
import com.meipan.library.api.model.Bookrack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyan on 17/3/11.
 */

public class RankingListFragment extends BaseFragment {
    public static final String TAG = "RankingListFragment";
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    int mType;
    RankingListAdapter mAdapter;
    int mPage;

    Bookrack bookrack1, bookrack2, bookrack3;
    List<Bookrack> list = new ArrayList<>();

    public static RankingListFragment newInstance(int type) {
        RankingListFragment fragment = new RankingListFragment();
        final Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        bookrack1 = new Bookrack();
        bookrack1.setName("天玉经");
        bookrack1.setImage(R.drawable.maingridview005);
        bookrack2 = new Bookrack();
        bookrack2.setName("灵枢经");
        bookrack2.setImage(R.drawable.ds008);
        bookrack3 = new Bookrack();
        bookrack3.setName("梅花喜神谱");
        bookrack3.setImage(R.drawable.ds012);
        mAdapter = new RankingListAdapter(context, null);
        initRequester();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_xrecycle_view, container, false);
        ButterKnife.bind(this, view);

        initRecyclerViewAsListView(mRecyclerView, false, null);

        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setAdapter(mAdapter);
        mType = getArguments().getInt("type", 0);
        if (mType ==0){
            list.add(bookrack1);
            list.add(bookrack1);
            list.add(bookrack1);
            list.add(bookrack1);
            list.add(bookrack1);
        } else if (mType ==1){
            list.add(bookrack2);
            list.add(bookrack2);
            list.add(bookrack2);
            list.add(bookrack2);
            list.add(bookrack2);
            list.add(bookrack2);
        } else{
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
        }
        refresh();
    }

    public void refresh() {
        mPage = 0;
        loadPage();
    }

    public void loadPage() {
        mAdapter.clear();
        for (int i = 0; i < list.size(); i++) {
            mAdapter.addBook(list.get(i));
        }

    }


    private void initRequester() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.
    }
}
