package com.zhuoxin.shopping.Base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhuoxin.shopping.entity.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/2.
 */
public class BaseListAdapter extends BaseAdapter{
    protected LayoutInflater inflater;
    protected List <Shop> list=new ArrayList<Shop>();
    protected Context context;
    public BaseListAdapter(Context context) {
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void setDataToAdapter(List<Shop> s){
        if(list!=null)
            list.addAll(s);
    }
    public void setDataToAdapter(Shop s){
        if(s!=null)
            list.add(s);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
