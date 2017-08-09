package com.example.xandone.viewpagerdemo.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xandone.viewpagerdemo.R;
import com.example.xandone.viewpagerdemo.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/9 16:54
 */

public class SimplePagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView title_tv;
    private int[] pics = {R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d};

    private SimpleAdapter<ImageView> simpleAdapter;
    private List<ImageView> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        title_tv = (TextView) findViewById(R.id.title_tv);

        title_tv.setText(getTitle());

        for (int i = 0; i < pics.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(pics[i]);
            list.add(imageView);
        }

        simpleAdapter = new SimpleAdapter(list);
        viewPager.setAdapter(simpleAdapter);
    }
}
