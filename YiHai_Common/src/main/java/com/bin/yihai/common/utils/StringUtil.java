package com.bin.yihai.common.utils;

/**
 * @program: Utopia
 * @description:
 * @author: Feri
 * @create: 2019-11-12 14:45
 */
public class StringUtil {
    public static boolean isEmpty(String... args){
        boolean r=false;
        for(String s:args){
            if(s==null || s.length()==0){
                r=true;
                break;
            }
        }
        return r;
    }
}
