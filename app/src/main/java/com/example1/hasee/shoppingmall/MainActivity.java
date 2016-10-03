package com.example1.hasee.shoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<View> datas = new ArrayList<>();
    ImageView[] mvs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initPoints();
    }

    private void initPoints() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.guide_group);
        int count = rg.getChildCount();
    }

    private void initData() {
        ImageView  a= new ImageView(this);
        ImageView  b= new ImageView(this);
        a.setImageResource(R.drawable.a);
        b.setImageResource(R.drawable.b);
        a.setScaleType(ImageView.ScaleType.FIT_XY);
        b.setScaleType(ImageView.ScaleType.FIT_XY);
        datas.add(a);
        datas.add(b);
    }
}
