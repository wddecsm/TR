package com.zhuoxin.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhuoxin.shopping.Base.BaseActivity;
import com.zhuoxin.shopping.R;
import com.zhuoxin.shopping.adapter.LeadPagerAdapter;

public class LeadActivity extends BaseActivity implements View.OnClickListener{
    private ImageView []images=new ImageView[4];
    private ViewPager pager;
    private LeadPagerAdapter adapter;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        initImages();
        initAdapter();
        initViewPager();
    }
    private void initImages(){
        images[0]= (ImageView) findViewById(R.id.lead_img1);
        images[1]= (ImageView) findViewById(R.id.lead_img2);
        images[2]= (ImageView) findViewById(R.id.lead_img3);
        images[3]= (ImageView) findViewById(R.id.lead_img4);
        button= (Button) findViewById(R.id.lead_btn);
        button.setOnClickListener(this);
    }


    private void initAdapter(){
        adapter=new LeadPagerAdapter(this);
        ImageView imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.lead_1);
        adapter.addDataToAdapter(imageView);
        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.lead_2);
        adapter.addDataToAdapter(imageView);
        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.lead_3);
        adapter.addDataToAdapter(imageView);
        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.lead_4);
        adapter.addDataToAdapter(imageView);
        adapter.notifyDataSetChanged();
    }
    private void initViewPager(){
        pager= (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(listener);
    }
    private ViewPager.OnPageChangeListener listener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for(int i=0;i<images.length;i++){
                images[i].setImageResource(R.drawable.adware_style_default);
            }
            images[position].setImageResource(R.drawable.adware_style_selected);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
