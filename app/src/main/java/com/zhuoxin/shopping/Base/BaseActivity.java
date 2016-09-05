package com.zhuoxin.shopping.Base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.zhuoxin.shopping.util.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/9/1.
 */
public class BaseActivity extends AppCompatActivity{
    final private static String TAG="调试信息：";
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.v(TAG,"onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.v(TAG,"onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.v(TAG,"onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.v(TAG,"onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.v(TAG,"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.v(TAG,"onDestroy");
    }
    private static ArrayList<BaseActivity> onlineActivityList=new ArrayList<BaseActivity>();
    public static void finishAll(){
        Iterator<BaseActivity> iterator=onlineActivityList.iterator();
        while (iterator.hasNext()){
            iterator.next().finish();
        }
    }


    protected void startActivity(Class<?> targetClass) {
        Intent intent = new Intent(this,targetClass);
        startActivity(intent);
    }

    protected void startActivity(Class<?> targetClass,Bundle bundle) {
        Intent intent = new Intent(this,targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void startActivity(Class<?> targetClass,int inAnimID,int outAnimID) {
        Intent intent = new Intent(this,targetClass);
        startActivity(intent);
        overridePendingTransition(inAnimID,outAnimID);
    }

    protected void startActivity(Class<?> targetClass,int inAnimID,int outAnimID,Bundle bundle) {
        Intent intent = new Intent(this,targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inAnimID,outAnimID);
    }
}


