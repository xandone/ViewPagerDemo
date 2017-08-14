package com.example.xandone.viewpagerdemo.anim;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * author: xandone
 * created on: 2017/8/14 16:18
 */

public class CustomTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9F;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) {
            //
            float scale = Math.max(MIN_SCALE, 1 - Math.abs(position));
            page.setScaleY(scale);
            Log.d("xandnone", "" + position);

        } else {
            page.setScaleY(MIN_SCALE);
        }
    }
}
