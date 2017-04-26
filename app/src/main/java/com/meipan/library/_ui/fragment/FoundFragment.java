package com.meipan.library._ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.meipan.library.R;
import com.meipan.library._ui.activity.FindBookListActivity;
import com.meipan.library._ui.activity.MoreFindActivity;
import com.meipan.library._ui.activity.RankingListActivity;
import com.meipan.library._ui.activity.nullActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发现
 */
public class FoundFragment extends BaseFragment {


    public FoundFragment() {
        // Required empty public constructor
    }

    public static FoundFragment newInstance() {
        FoundFragment fragment = new FoundFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_found, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.ranking)
    public void onRanking(View view){
        startActivity(new Intent(getActivity(), RankingListActivity.class));
    }

    @OnClick(R.id.celebrity)
    public void onCelebrity(View view){
        startActivity(new Intent(getActivity(),FindBookListActivity.class));
    }


    @OnClick(R.id.book_review)
    public void onBookReview(View view){
        Intent intent = new Intent(getActivity(),MoreFindActivity.class);
        intent.putExtra("type",FindBookListFragment.COMMCENT);
        intent.putExtra("title","书评广场");
        startActivity(intent);
    }


    @OnClick(R.id.special)
    public void onSpecial(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","专题");
        startActivity(intent);
    }


    @OnClick(R.id.monthly)
    public void onMonthly(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","包月");
        startActivity(intent);
    }


    @OnClick(R.id.free)
    public void onFree(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","今日免费");
        startActivity(intent);
    }


    @OnClick(R.id.task)
    public void onTask(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","福利任务");
        startActivity(intent);
    }

    @OnClick(R.id.game)
    public void onGame(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","游戏");
        startActivity(intent);
    }

    @OnClick(R.id.recommend)
    public void onRecommend(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","古籍推荐");
        startActivity(intent);
    }

}
