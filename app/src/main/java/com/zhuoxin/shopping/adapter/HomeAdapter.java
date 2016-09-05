package com.zhuoxin.shopping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuoxin.shopping.Base.BaseListAdapter;
import com.zhuoxin.shopping.OkHttp.DBBitmap;
import com.zhuoxin.shopping.R;

/**
 * Created by Administrator on 2016/9/2.
 */
public class HomeAdapter extends BaseListAdapter{
    public HomeAdapter(Context context) {
        super(context);
    }
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view=inflater.inflate(R.layout.home_item_list,null);
        }
        ImageView min= (ImageView) view.findViewById(R.id.min);
        TextView name= (TextView) view.findViewById(R.id.name);
        TextView price= (TextView) view.findViewById(R.id.price);
        TextView s_price= (TextView) view.findViewById(R.id.s_price);
        new DBBitmap(min,list.get(i).getImg_path()).execute();
        name.setText(list.get(i).getName());
        price.setText(""+ list.get(i).getPrice());
        s_price.setText(""+ list.get(i).getS_price());
        return view;
    }
}
