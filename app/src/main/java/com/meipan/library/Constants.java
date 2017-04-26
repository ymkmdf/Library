package com.meipan.library;

import android.os.Environment;

import java.io.File;

/**
 * Created by gaoyan on 17/3/1.
 */

public class Constants {
    public final static String ROOT = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator;
    public final static String APP_ROOT = ROOT + "cangshuge" + File.separator;
    public final static String IMAGE_CACHE_ROOT = APP_ROOT + "images" + File.separator;
}
