package com.zhuoxin.shopping.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/1.
 */
public class LogUtil {
    final static private boolean v=true;
    final static private boolean d=true;
    public static void v(String tag,String message){
        if (v)
        Log.v(tag,message);
    }
    public static void d(String tag,String message){
        if(d)
            Log.d(tag,message);
    }
}
