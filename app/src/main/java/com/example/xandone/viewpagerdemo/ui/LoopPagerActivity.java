package com.example.xandone.viewpagerdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xandone.viewpagerdemo.R;
import com.example.xandone.viewpagerdemo.adapter.LoopSimpleAdapter;
import com.example.xandone.viewpagerdemo.utils.PicsUtils;
import com.example.xandone.viewpagerdemo.view.LoopViewPager;

import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/14 15:20
 */

public class LoopPagerActivity extends AppCompatActivity {
    private LoopViewPager viewPager;
    private TextView title_tv;

    private LoopSimpleAdapter<ImageView> loopSimpleAdapter;
    private List<ImageView> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loop_layout);
        viewPager = (LoopViewPager) findViewById(R.id.viewPager);
        title_tv = (TextView) findViewById(R.id.title_tv);

        title_tv.setText(getTitle());

        list = PicsUtils.getImageList(this, PicsUtils.pic3);
        loopSimpleAdapter = new LoopSimpleAdapter(list);
        viewPager.setAdapter(loopSimpleAdapter);
    }
}
