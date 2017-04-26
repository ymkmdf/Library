package com.meipan.library.messager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gaoyan on 17/2/28.
 */

public class Messager {
    private final ConcurrentHashMap<String,Object> m = new ConcurrentHashMap<String, Object>();

    public boolean containsKey(String key){
        return m.containsKey(key);
    }

    public Object get(String key) {
        return m.get(key);
    }

    public void put(String key, Object value) {
        m.put(key, value);
    }

    public Object remove(String key) {
        return m.remove(key);
    }
}
