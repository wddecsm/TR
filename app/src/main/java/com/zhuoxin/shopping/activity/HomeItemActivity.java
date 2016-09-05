package com.zhuoxin.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.zhuoxin.shopping.Base.TitleActionbar;
import com.zhuoxin.shopping.OkHttp.DBMessage;
import com.zhuoxin.shopping.R;
import com.zhuoxin.shopping.adapter.HomeAdapter;
import com.zhuoxin.shopping.entity.Shop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeItemActivity extends AppCompatActivity {
    private HomeAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_item);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String name=intent.getStringExtra("name");
        TitleActionbar.init(name);
        activity(id);

    }
    private void init(List<Shop> list){
        adapter=new HomeAdapter(this);
        adapter.setDataToAdapter(list);
        listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


    private void activity(String id) {
        DBMessage.str=null;
        new DBMessage().DBIO("Home",id);
        final String[] str = new String[1];
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                do{
                    str[0] =DBMessage.str;
                }while (str[0]==null);
                Log.v("****8****",str[0]);
                init(getList(str[0]));
            }
        });

    }
    private ArrayList<Shop> getList(String str){
        ArrayList <Shop> list=new ArrayList<Shop>();
        try{
            JSONArray ja=new JSONArray(str);
            for(int i=0;i<ja.length();i++){
                JSONObject jo= ja.getJSONObject(i);
                Shop shop =new Shop();
                shop.setImg_path(jo.getString("img_path"));
                shop.setMax_path(jo.getString("max_path"));
                shop.setName(jo.getString("name"));
                shop.setNumber(jo.getInt("number"));
                shop.setNumbers(jo.getInt("numbers"));
                shop.setRemark(jo.getString("remark"));
                shop.setPrice(jo.getDouble("price"));
                shop.setS_price(jo.getDouble("s_price"));
                list.add(shop);
                Log.v("*********",list.get(i).getMax_path()+"");
            }
        }
        catch(Exception e){
        }
        return list;
    }
}
