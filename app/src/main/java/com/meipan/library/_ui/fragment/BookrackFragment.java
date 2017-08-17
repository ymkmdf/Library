package com.meipan.library._ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.meipan.library.R;
import com.meipan.library._ui.adapter.BookrackAdapter;
import com.meipan.library.api.model.Bookrack;
import com.meipan.library.widget.NestedRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 书架
 */
public class BookrackFragment extends BaseFragment {
    private static final String TAG = BookrackFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh)
    NestedRefreshLayout mRefresh;

    private BookrackAdapter mAdapter;
    private int mPage = 0;
    private List<Bookrack> list = new ArrayList<>();

    public static BookrackFragment newInstance() {
        BookrackFragment fragment = new BookrackFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bookrack bookrack1 = new Bookrack();
        bookrack1.setName("天玉经");
        bookrack1.setImage(R.drawable.maingridview005);
        list.add(bookrack1);
        Bookrack bookrack2 = new Bookrack();
        bookrack2.setName("灵枢经");
        bookrack2.setImage(R.drawable.ds008);
        list.add(bookrack2);
        Bookrack bookrack3 = new Bookrack();
        bookrack3.setName("梅花喜神谱");
        bookrack3.setImage(R.drawable.ds012);
        list.add(bookrack3);
        Bookrack bookrack4 = new Bookrack();
        bookrack4.setName("道德经");
        bookrack4.setImage(R.drawable.ds016);
        list.add(bookrack4);
        list.add(bookrack1);
        list.add(bookrack2);
        list.add(bookrack3);
        list.add(bookrack4);
        mAdapter = new BookrackAdapter(context ,null);
        initRequester();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_xrecycle_view, container, false);
        ButterKnife.bind(this, view);

        initRecyclerViewAsListView(mRecyclerView,false,null);

        return view;
    }

    public void refreshPage(){
        refresh();
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setAdapter(mAdapter);
        mRefresh.setOnRefreshListener(new NestedRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefresh.refreshFinish();
            }
        });
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
            mAdapter.addRecommend("123");
        } else {
//            mRecyclerView.setLoadingMoreEnabled(false);
        }

        for (int i = 0 ;i < list.size(); i++){

            mAdapter.addBookrack(list.get(i));
        }
        mPage=mPage+1;
    }

    private void initRequester() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.
    }

}
