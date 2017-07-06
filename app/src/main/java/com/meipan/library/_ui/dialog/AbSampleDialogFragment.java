/*
 * Copyright (C) 2012 www.amsoft.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.meipan.library._ui.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.meipan.library.R;

import butterknife.OnClick;
// TODO: Auto-generated Javadoc

/**
 * 描述：弹出框
 */
public class AbSampleDialogFragment extends DialogFragment {

    /**
     * The m theme.
     */
    protected int mTheme;

    /**
     * The m style.
     */
    protected int mStyle;

    /**
     * The m gravity.
     */
    protected int mGravity;

    /**
     * The m content view.
     */
    private View mContentView;

    /**
     * The m on cancel listener.
     */
    private DialogInterface.OnCancelListener mOnCancelListener = null;

    /**
     * The m on dismiss listener.
     */
    private DialogInterface.OnDismissListener mOnDismissListener = null;


    /* (non-Javadoc)
     * @see android.app.DialogFragment#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(mStyle, mTheme);
    }

    /* (non-Javadoc)
     * @see android.app.DialogFragment#onCancel(android.content.DialogInterface)
     */
    @Override
    public void onCancel(DialogInterface dialog) {
        // 用户中断
        if (mOnCancelListener != null) {
            mOnCancelListener.onCancel(dialog);
        }

        super.onCancel(dialog);
    }

    /* (non-Javadoc)
     * @see android.app.DialogFragment#onDismiss(android.content.DialogInterface)
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        // 用户隐藏
        if (mOnDismissListener != null) {
            mOnDismissListener.onDismiss(dialog);
        }
        super.onDismiss(dialog);
    }

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mContentView;
    }

    /* (non-Javadoc)
     * @see android.app.DialogFragment#onActivityCreated(android.os.Bundle)
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = mGravity;
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparency5)));
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * Gets the content view.
     *
     * @return the content view
     */
    public View getContentView() {
        return mContentView;
    }

    /**
     * Sets the content view.
     *
     * @param mContentView the new content view
     */
    public void setContentView(View mContentView) {
        this.mContentView = mContentView;
    }

    /**
     * Gets the on cancel listener.
     *
     * @return the on cancel listener
     */
    public DialogInterface.OnCancelListener getOnCancelListener() {
        return mOnCancelListener;
    }

    /**
     * Sets the on cancel listener.
     *
     * @param onCancelListener the new on cancel listener
     */
    public void setOnCancelListener(
            DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    /**
     * Gets the on dismiss listener.
     *
     * @return the on dismiss listener
     */
    public DialogInterface.OnDismissListener getOnDismissListener() {
        return mOnDismissListener;
    }

    /**
     * Sets the on dismiss listener.
     *
     * @param onDismissListener the new on dismiss listener
     */
    public void setOnDismissListener(
            DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }
//
//    @OnClick(R.id.out_layout)
//    public void onOutLayoutClick(View view) {
//        dismiss();
//    }
}

