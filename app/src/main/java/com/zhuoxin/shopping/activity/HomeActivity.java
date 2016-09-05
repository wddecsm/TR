package com.zhuoxin.shopping.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuoxin.shopping.Base.BaseActivity;
import com.zhuoxin.shopping.OkHttp.DBBitmap;
import com.zhuoxin.shopping.R;
import com.zhuoxin.shopping.adapter.LeadPagerAdapter;


public class HomeActivity extends BaseActivity implements View.OnClickListener{

    private LeadPagerAdapter adapter;
    private ImageView[] images = new ImageView[3];
    private ViewPager pager;
    private ImageView image=null;
    private TextView[] textViews=new TextView[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initTextView();
        initImageView();
        initAdapter();
        initPager();
    }

    private void initImageView() {
        images[0] = (ImageView) findViewById(R.id.home_img1);
        images[1] = (ImageView) findViewById(R.id.home_img2);
        images[2] = (ImageView) findViewById(R.id.home_img3);
    }

    private void initAdapter() {
        adapter = new LeadPagerAdapter(this);;
        for(int i=1;i<=3;i++) {
            image = (ImageView) getLayoutInflater().inflate(R.layout.home_item, null);
            DBBitmap btmap = new DBBitmap(image, "images/img_" + i + ".png");
            btmap.execute();
            adapter.addDataToAdapter(image);
        }
        adapter.notifyDataSetChanged();
    }


    private void initPager() {
        pager = (ViewPager) findViewById(R.id.home_pager);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(listener);
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < images.length; i++) {
                images[i].setImageResource(R.drawable.adware_style_default);
            }
                images[position].setImageResource(R.drawable.adware_style_selected);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private void initTextView(){
        textViews[0]= (TextView) findViewById(R.id.home_text1);
        textViews[1]= (TextView) findViewById(R.id.home_text2);
        textViews[2]= (TextView) findViewById(R.id.home_text3);
        textViews[3]= (TextView) findViewById(R.id.home_text4);
        textViews[4]= (TextView) findViewById(R.id.home_text5);
        textViews[5]= (TextView) findViewById(R.id.home_text6);
        for(int i=0;i<textViews.length;i++){
            textViews[i].setOnClickListener(this);
        }

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_text1:
                starAction("1",textViews[0].getText().toString());
                break;
            case R.id.home_text2:
                starAction("2",textViews[1].getText().toString());
                break;
            case R.id.home_text3:
                starAction("3",textViews[2].getText().toString());
                break;
            case R.id.home_text4:
                starAction("4",textViews[3].getText().toString());
                break;
            case R.id.home_text5:
                starAction("5",textViews[4].getText().toString());
                break;
            case R.id.home_text6:
                starAction("6",textViews[5].getText().toString());
                break;
        }
    }
    private void starAction(String id,String name){
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        bundle.putString("name",name);
        startActivity(HomeItemActivity.class,bundle);
    }

}
