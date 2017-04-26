package com.meipan.library.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class CustomViewPager extends ViewPager {

    private boolean noScroll = false;
    private ViewGroup parent;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public CustomViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    public void setNestedpParent(ViewGroup parent,boolean scroll) {
        this.parent = parent;
        this.noScroll = scroll;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (parent != null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (noScroll) {
            return false;
        }else {
            if (parent != null){
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(arg0);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        }else {
            if (parent != null){
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(arg0);
        }
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    public void setCurrentItme(int item,boolean smoothScroll,boolean noScroll){
        setCurrentItem(item, smoothScroll);
        this.noScroll = noScroll;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

}