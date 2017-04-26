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
import com.meipan.library._ui.adapter.ClassificationAdapter;
import com.meipan.library._ui.adapter.RankingListAdapter;
import com.meipan.library.api.model.Bookrack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyan on 17/3/15.
 */

public class ClassificationFragment extends BaseFragment {



    @BindView(R.id.recycler_view)
    RecyclerView mRecycleView;
    ClassificationAdapter mAdapter;
    int mPage;
    int mType;
    Bookrack bookrack1, bookrack2, bookrack3,bookrack4;
    List<Bookrack> list = new ArrayList<>();
    public static ClassificationFragment newInstance(int type){
        ClassificationFragment fragment = new ClassificationFragment();
        final Bundle args = new Bundle();
        args.putInt("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAdapter = new ClassificationAdapter(getActivity(),null);

        bookrack1 = new Bookrack();
        bookrack1.setName("天玉经");
        bookrack1.setImage(R.drawable.maingridview005);
        bookrack2 = new Bookrack();
        bookrack2.setName("灵枢经");
        bookrack2.setImage(R.drawable.ds008);
        bookrack3 = new Bookrack();
        bookrack3.setName("梅花喜神谱");
        bookrack3.setImage(R.drawable.ds012);
        bookrack4 = new Bookrack();
        bookrack4.setName("道德经");
        bookrack4.setImage(R.drawable.ds016);
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
        } else if (mType ==2){
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
            list.add(bookrack3);
        }else {
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
            list.add(bookrack4);
        }

        refresh();

    }

    public void refresh(){
        mPage = 0;
        loadPage();
    }

    public void loadPage(){
        if (mPage == 0){
            mAdapter.clear();
        }

        for (int i=0;i<list.size();i++){
            mAdapter.addBook(list.get(i));
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }


    public void initRequester(){

    }
}
