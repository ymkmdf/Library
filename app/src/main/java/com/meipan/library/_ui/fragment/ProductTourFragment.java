package com.meipan.library._ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;

import org.greenrobot.eventbus.EventBus;

/**
 * 产品说明（故事）
 */
public class ProductTourFragment extends Fragment implements View.OnClickListener {
    final static String LAYOUT_ID = "layoutid";

    public static ProductTourFragment newInstance(int layoutId) {
        ProductTourFragment pane = new ProductTourFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        pane.setArguments(args);
        return pane;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(getArguments().getInt(LAYOUT_ID, -1), container, false);
        final View view;// 包含 start 按钮
        if ((view = rootView.findViewById(R.id.start_button)) != null) {
            view.setOnClickListener(this);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
//        EventBus.getDefault().post(new ActionEvent("start_button_click"));
    }
}