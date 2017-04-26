package com.meipan.library._ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.meipan.library.R;
import com.meipan.library._ui.activity.LoginActivity;
import com.meipan.library._ui.activity.SettingActivity;
import com.meipan.library._ui.activity.nullActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vaio on 2016/8/21.
 */
public class MeFramgnet extends BaseFragment {

    public static MeFramgnet newInstance(){
        MeFramgnet fragment = new MeFramgnet();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_me,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.setting)
    public void onSetting(View view){
        getActivity().startActivity(new Intent(getActivity(), SettingActivity.class));
    }

    @OnClick(R.id.icon)
    public void onIcon(View view){
        getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @OnClick(R.id.feedback)
    public void onFeeback(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","反馈");
        startActivity(intent);
    }

    @OnClick(R.id.record)
    public void onRecord(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","记录");
        startActivity(intent);
    }

    @OnClick(R.id.voucher)
    public void onVoucher(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","抵用券");
        startActivity(intent);
    }

    @OnClick(R.id.collection)
    public void onCollection(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","我的收藏");
        startActivity(intent);
    }

    @OnClick(R.id.coin)
    public void onCoin(View view){
        Intent intent = new Intent(getActivity(),nullActivity.class);
        intent.putExtra("title","我的书币");
        startActivity(intent);
    }
}
