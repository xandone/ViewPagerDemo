package com.example.xandone.viewpagerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xandone.viewpagerdemo.R;
import com.example.xandone.viewpagerdemo.adapter.SimpleAdapter;
import com.example.xandone.viewpagerdemo.utils.PicsUtils;
import com.example.xandone.viewpagerdemo.view.AutoViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/10 14:52
 */

public class AutoPagerActivity extends AppCompatActivity {
    private AutoViewPager viewPager;
    private TextView title_tv;

    private SimpleAdapter<ImageView> simpleAdapter;
    private List<ImageView> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auto_layout);
        viewPager = (AutoViewPager) findViewById(R.id.viewPager);
        title_tv = (TextView) findViewById(R.id.title_tv);

        title_tv.setText(getTitle());
        list = PicsUtils.getImageList(this, PicsUtils.pic4);

        simpleAdapter = new SimpleAdapter(list);
        viewPager.setAdapter(simpleAdapter);
        viewPager.start(2000);

        title_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoPagerActivity.this, ShadeActivity.class));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewPager.stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.start(2000);
    }
}
