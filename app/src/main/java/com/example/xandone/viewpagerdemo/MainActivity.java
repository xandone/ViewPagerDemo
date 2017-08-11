package com.example.xandone.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xandone.viewpagerdemo.ui.AutoPagerActivity;
import com.example.xandone.viewpagerdemo.ui.SimplePagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.vp_simple).setOnClickListener(this);
        findViewById(R.id.vp_auto).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.vp_simple:
                intent.setClass(this, SimplePagerActivity.class);
                break;
            case R.id.vp_auto:
                intent.setClass(this, AutoPagerActivity.class);
                break;
        }
        startActivity(intent);
    }
}
