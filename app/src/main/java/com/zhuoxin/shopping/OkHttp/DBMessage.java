package com.zhuoxin.shopping.OkHttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DBMessage {
    OkHttpClient client = new OkHttpClient();
    Object read;
    public static String str=null;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Object DBRead() {
        //6.1创建一个Request请求
        String url = "http://192.168.1.146:8080/shoppings/Json";
        //创建request请求
        final Request request = new Request.Builder().get().tag(this).url(url).build();
        //创建一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //定义一个响应
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        read = response.body().string();
                        Log.v("读取服务器成功", read + "");
                    } else {
                        Log.v("读取服务器失败", response.code() + "");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return read;
    }

    //定义向服务器发送数据的类型
    public Object DBIO(String servlet, final String id) {
        final Object[] obj = new Object[1];
        String url = "http://192.168.1.146:8080/shoppings/"+servlet;
        //需要发送的内容
        RequestBody fromBody = RequestBody.create(JSON,id);
        //创建一个requset对象
        final Request request = new Request.Builder().url(url).post(fromBody).build();
        //线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        str = response.body().string();
                        Log.v("向服务器发送数据成功:" + id, "接受服务器数据成功" + str);
                    } else {
                        Log.v("响应服务器失败", response.code() + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
        return obj;
    }

}


