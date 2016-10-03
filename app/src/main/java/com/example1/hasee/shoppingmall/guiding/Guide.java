package com.example1.hasee.shoppingmall.guiding;

import android.content.Intent;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example1.hasee.shoppingmall.MainActivity;
import com.example1.hasee.shoppingmall.R;

import java.util.ArrayList;
import java.util.logging.Handler;

public class Guide extends AppCompatActivity {

    ArrayList<View> datas = new ArrayList<>();
    ImageView[] mvs;
    private LinearLayout mRg;
    GuideAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initPoints();
        initView();
    }
    int current = 0;
    private void initView() {
        ViewPager vp = (ViewPager) findViewById(R.id.guide_viewPager);
        mAdapter = new GuideAdapter(datas);
        vp.setAdapter(mAdapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position ==current){
                    mvs[position].setImageResource(android.R.drawable.presence_online);
                }else {
                    mvs[position].setImageResource(android.R.drawable.presence_online);

                    mvs[current].setImageResource(android.R.drawable.presence_invisible);
                    current = position;
                }
                if (position==datas.size()-1){
                    mRg.setVisibility(View.GONE);
                }else {
                    mRg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initPoints() {
        mRg = (LinearLayout) findViewById(R.id.guide_group);
        int count = mRg.getChildCount();
        mvs = new ImageView[count];
        for (int i = 0; i<count;i++){
            ImageView x = (ImageView) mRg.getChildAt(i);
            mvs[i] = x;
        }
    }

    private void initData() {


                ImageView  a= new ImageView(Guide.this);
                ImageView  b= new ImageView(Guide.this);
                a.setImageResource(R.drawable.a);
                b.setImageResource(R.drawable.b);
                a.setScaleType(ImageView.ScaleType.FIT_XY);
                b.setScaleType(ImageView.ScaleType.FIT_XY);
                datas.add(a);
                datas.add(b);

                FrameLayout c = (FrameLayout) View.inflate(Guide.this,R.layout.guid_third,null);
                datas.add(c);



    }
    public void jump(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
