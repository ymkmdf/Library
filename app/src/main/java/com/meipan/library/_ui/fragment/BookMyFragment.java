package com.meipan.library._ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.meipan.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 书库
 */
public class BookMyFragment extends BaseFragment {




    public BookMyFragment() {
        // Required empty public constructor
    }

    public static BookMyFragment newInstance(){
        BookMyFragment fragment = new BookMyFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_library, container, false);
//        ButterKnife.bind(this, view);
//        titleText.setText("发现");
//        backButton.setVisibility(View.INVISIBLE);
//        init();
        return null;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }
}
