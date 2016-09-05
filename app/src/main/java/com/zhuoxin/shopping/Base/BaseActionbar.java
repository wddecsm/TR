package com.zhuoxin.shopping.Base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zhuoxin.shopping.R;

/**
 * Created by Administrator on 2016/8/31.
 */
public class BaseActionbar extends LinearLayout {
    private static Button image1;//首页按钮
    private static Button image2;//搜索按钮
    private static Button image3;//品牌按钮
    private static Button image4;//购物车
    private static Button image5;//更多
    private static Context targetClass;

    public BaseActionbar(Context context) {
        super(context);
        targetClass=context;
    }
    public BaseActionbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.actionbar,this);
        image1= (Button) findViewById(R.id.image1);
        image2= (Button) findViewById(R.id.image2);
        image3= (Button) findViewById(R.id.image3);
        image4= (Button) findViewById(R.id.image4);
        image5= (Button) findViewById(R.id.image5);
        initActionBar();
    }
    private static OnClickListener listener=new OnClickListener() {
        @Override
        public void onClick(View view) {
            image1.setBackgroundResource(R.drawable.bar_home_normal);
            image2.setBackgroundResource(R.drawable.bar_search_normal);
            image3.setBackgroundResource(R.drawable.bar_class_normal);
            image4.setBackgroundResource(R.drawable.bar_shopping_normal);
            image5.setBackgroundResource(R.drawable.bar_more_normal);
            switch (view.getId()) {
                case R.id.image1:
                    image1.setBackgroundResource(R.drawable.bar_home_selected);
                    break;
                case R.id.image2:
                    image2.setBackgroundResource(R.drawable.bar_search_selected);
                    break;
                case R.id.image3:
                    image3.setBackgroundResource(R.drawable.bar_class_selected);
                    break;
                case R.id.image4:
                    image4.setBackgroundResource(R.drawable.bar_shopping_selected);
                    break;
                case R.id.image5:
                    image5.setBackgroundResource(R.drawable.bar_more_selected);
                    break;
            }
        }
    };

    public static void initActionBar(){
        image1.setOnClickListener(listener);
        image2.setOnClickListener(listener);
        image3.setOnClickListener(listener);
        image4.setOnClickListener(listener);
        image5.setOnClickListener(listener);
        }

}
