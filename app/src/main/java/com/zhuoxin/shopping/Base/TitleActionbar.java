package com.zhuoxin.shopping.Base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuoxin.shopping.R;

/**
 * Created by Administrator on 2016/9/2.
 */
public class TitleActionbar extends LinearLayout {
    private static TextView textView;
    private static Button button;

    public TitleActionbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.title_actionbar, this);
        textView = (TextView) findViewById(R.id.bar_tv);
        button = (Button) findViewById(R.id.bar_btn);
        button.setOnClickListener(listener);
    }
    public static void init(String title){
        textView.setText(title);
    }

    OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            System.exit(0);
        }
    };

}