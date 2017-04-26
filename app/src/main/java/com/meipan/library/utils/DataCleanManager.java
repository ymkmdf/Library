package com.meipan.library.utils;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by vaio on 2016/9/17.
 */
public class DataCleanManager {
    public static String getCacheSize(File path){
        long cacheSize = 0;
        try {
            cacheSize = getFolderSize(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFormatSize(cacheSize);
    }

    public static long getFolderSize(File file) throws Exception{
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for(int i = 0; i<fileList.length;i++){
                if (fileList[i].isDirectory()){
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return size;
    }

    public static String getFormatSize(double size){
        double kiloByte = size / 1024;
        if (kiloByte < 1){
            return "0K" ;
        }
        double megaByte = kiloByte / 1024;
        if (megaByte <1){
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }
        double gigaByte = megaByte / 1024;
        if (gigaByte <1){
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }
        double teraByte = gigaByte / 1024;
        if (teraByte <1){
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(Double.toString(teraByte));
        return result4.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }
}
