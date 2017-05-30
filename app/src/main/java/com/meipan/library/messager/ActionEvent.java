package com.meipan.library.messager;

/**
 * Created by gaoyan on 17/3/8.
 */

public class ActionEvent {
    private Object data;
    private Object arg1;
    private Object arg2;
    private Object arg3;
    private String mAction;

    public ActionEvent(String action) {
        mAction = action;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public String getAction() {
        return mAction;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Object getArg1() {
        return arg1;
    }

    public void setArg1(Object arg1) {
        this.arg1 = arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public void setArg2(Object arg2) {
        this.arg2 = arg2;
    }

    public Object getArg3() {
        return arg3;
    }

    public void setArg3(Object arg3) {
        this.arg3 = arg3;
    }
}
