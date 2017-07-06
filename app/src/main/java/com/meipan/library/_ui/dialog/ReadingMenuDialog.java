package com.meipan.library._ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meipan.library.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kougan on 2017/6/3.
 */

public class ReadingMenuDialog extends AbSampleDialogFragment {
    private static final String TAG = ReadingMenuDialog.class.getSimpleName();

    public static ReadingMenuDialog getInstance(String str){
        final ReadingMenuDialog dialog = new ReadingMenuDialog();
        Bundle args = new Bundle();
        dialog.setArguments(args);
        args.putString("string",str);
        return dialog;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mStyle = DialogFragment.STYLE_NORMAL;
        mTheme = android.R.style.Theme_NoTitleBar;
        mGravity = Gravity.CENTER;
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_reading_menu,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //设置内容
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.black_image,R.id.black_text,R.id.close})
    public void onClose(View view){
        dismiss();
    }


}
