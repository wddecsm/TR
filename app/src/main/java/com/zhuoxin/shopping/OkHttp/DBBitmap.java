package com.zhuoxin.shopping.OkHttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/31.
 */
public class DBBitmap  extends AsyncTask<String,Float,Bitmap> {
    final static String url_1 = "http://192.168.1.146:8080/shoppings/";
    private ImageView imageView;
    private String url=null;

    public DBBitmap(ImageView imageView,String url_2) {
        this.imageView = imageView;
        this.url=url_1+url_2;
        Log.v("*****DBBitmap*****",url);
    }


    @Override
    protected void onPostExecute(Bitmap o) {
        imageView.setImageBitmap(o);
    }

    @Override
    protected Bitmap doInBackground(String... bitmaps) {
        Bitmap bitmap = null;
        try {
            //加载一个网络图片
            InputStream is = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}


