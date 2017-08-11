package com.example.xandone.viewpagerdemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * author: xandone
 * created on: 2017/8/10 14:16
 */

public class AutoViewPager extends ViewPager {
    private int mCurrentIndex;
    private boolean isCanSlide;
    private int mApartTime;
    private int mCurrentState;

    public static final int STATE_SLEDE = 100;
    public static final int STATE_STOP = 101;


    public AutoViewPager(Context context) {
        this(context, null);
    }

    public AutoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        mCurrentIndex = 0;
        isCanSlide = false;
        mCurrentState = STATE_STOP;

        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mCurrentIndex = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        stop();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        stop();
                        break;
                    case MotionEvent.ACTION_UP:
                        start(mApartTime);
                        break;
                }

                return false;
            }
        });

    }

    /**
     * 开始滑动
     *
     * @param apartTime
     */
    public void start(int apartTime) {
        //滑动状态下不需要重新开启
        if (isCanSlide) {
            return;
        }
        if (getAdapter() == null) {
            return;
        }
        int size = getAdapter().getCount();
        if (size <= 1 || apartTime <= 0) {
            return;
        }
        isCanSlide = true;
        mApartTime = apartTime;
        apartRunnable.init(size, apartTime);
        postDelayed(apartRunnable, apartTime);
    }

    /**
     * 停止滑动
     */
    public void stop() {
        Log.d("xandone", "----stop----");
        if (isCanSlide) {
            isCanSlide = false;
            removeCallbacks(apartRunnable);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    ApartRunnable apartRunnable = new ApartRunnable();

    private class ApartRunnable implements Runnable {
        private int size;
        private int apartTime;

        public void init(int size, int apartTime) {
            this.size = size;
            this.apartTime = apartTime;
        }

        @Override
        public void run() {
            if (isCanSlide) {
                mCurrentIndex = ++mCurrentIndex % size;
//                setCurrentItem(mCurrentIndex, false); false切换item没有滑动效果
                setCurrentItem(mCurrentIndex);
                postDelayed(apartRunnable, apartTime);
            }
        }
    }

}
