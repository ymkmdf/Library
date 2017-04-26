package com.meipan.library.utils;

import java.util.Collection;

/**
 * @author vaio.com
 */
public class ListUtils {
    private static final String TAG = ListUtils.class.getSimpleName();

    public static int getSize(Collection<?> list) {
        return list == null ? 0 : list.size();
    }
}