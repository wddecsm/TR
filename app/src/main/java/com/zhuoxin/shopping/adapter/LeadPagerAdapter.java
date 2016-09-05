package com.zhuoxin.shopping.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/19.
 */
public class LeadPagerAdapter extends PagerAdapter{

    protected Context context;
    private ArrayList<View> viewList=new ArrayList<View>();
    private ArrayList<String> titlelist=new ArrayList<String>();
    public LeadPagerAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<View> getViewList(){
        return viewList;
    }
    public ArrayList<String> getTitlelist(){
        return titlelist;
    }
    public void addDataToAdapter(View view){
        if (view!=null)
            viewList.add(view);
    }
    public void addDataToAdapter(String title){
        if (title!=null)
            titlelist.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=viewList.get(position);
        container.removeView(view);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=viewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}

