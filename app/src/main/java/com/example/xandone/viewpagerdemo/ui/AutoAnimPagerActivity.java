package com.example.xandone.viewpagerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xandone.viewpagerdemo.R;
import com.example.xandone.viewpagerdemo.adapter.SimpleAdapter;
import com.example.xandone.viewpagerdemo.anim.CustomTransformer;
import com.example.xandone.viewpagerdemo.utils.PicsUtils;
import com.example.xandone.viewpagerdemo.view.AutoViewPager;

import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/10 14:52
 */

public class AutoAnimPagerActivity extends AppCompatActivity {
    private AutoViewPager viewPager;
    private TextView title_tv;

    private SimpleAdapter<ImageView> simpleAdapter;
    private List<ImageView> list;

    private CustomTransformer customTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_auto_anim_layout);
        viewPager = (AutoViewPager) findViewById(R.id.viewPager);
        title_tv = (TextView) findViewById(R.id.title_tv);

        title_tv.setText(getTitle());
        list = PicsUtils.getImageList(this, PicsUtils.pic3);

        simpleAdapter = new SimpleAdapter(list);
        customTransformer = new CustomTransformer();
        viewPager.setAdapter(simpleAdapter);
        viewPager.setPageTransformer(false, customTransformer);
        viewPager.start(2000);

        title_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoAnimPagerActivity.this, ShadeActivity.class));
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
