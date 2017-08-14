package com.example.xandone.viewpagerdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/9 16:59
 */

public class LoopSimpleAdapter<T extends View> extends PagerAdapter {
    private List<T> list;

    public LoopSimpleAdapter(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (list.get(position).getParent() != null) {
            ((ViewGroup) list.get(position).getParent()).removeView(list.get(position));
        }
        container.addView(list.get(position));
        return list.get(position);
    }
}
