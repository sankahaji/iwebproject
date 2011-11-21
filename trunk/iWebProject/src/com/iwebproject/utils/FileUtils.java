package com.iwebproject.utils;

public class FileUtils {
    /**
     * 获取文件的扩展名
     * 
     * @param fileName
     * @return
     */
    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos).toLowerCase();
    }
}
