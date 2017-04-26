package com.meipan.library.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * @author wanggeng@nq.com
 */
public class DisplayUtils {
    private static final String TAG = DisplayUtils.class.getSimpleName();
    private static DisplayMetrics sDisplayMetrics;
    private static int sStatusBarHeight = -1;

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            sDisplayMetrics = context.getResources().getDisplayMetrics();
        }
        return sDisplayMetrics;
    }

    public static float dpToPx(Context context, float dp) {
        return dp * getDisplayMetrics(context).density;
    }

    public static float pxToDp(Context context, float px) {
        return px / getDisplayMetrics(context).density;
    }

    public static int dpToPxInt(Context context, float dp) {
        return (int) (dpToPx(context, dp) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        if (sStatusBarHeight == -1) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                sStatusBarHeight = context.getResources().getDimensionPixelSize(x);
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "getStatusBarHeight", e);
            } catch (InstantiationException e) {
                Log.e(TAG, "getStatusBarHeight", e);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "getStatusBarHeight", e);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "getStatusBarHeight", e);
            }
        }
        return sStatusBarHeight;
    }
}