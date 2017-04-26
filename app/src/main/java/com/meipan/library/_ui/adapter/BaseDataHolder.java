package com.meipan.library._ui.adapter;

import android.content.Context;

/**
 * Created by gaoyan on 17/3/4.
 */
public class BaseDataHolder<D extends BaseDataHolder> {
    private int mType;

    public BaseDataHolder(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}
