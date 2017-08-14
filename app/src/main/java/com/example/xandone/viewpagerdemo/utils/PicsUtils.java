package com.example.xandone.viewpagerdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.example.xandone.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xandone
 * created on: 2017/8/14 15:31
 */

public class PicsUtils {
    public static int[] pic1 = {R.mipmap.a};

    public static int[] pic2 = {R.mipmap.a,
            R.mipmap.b};

    public static int[] pic3 = {R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c};

    public static int[] pic4 = {R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d};

    public static List<ImageView> getImageList(Context context, int[] pic) {
        List list = new ArrayList();
        for (int i = 0; i < pic.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(pic[i]);
            list.add(imageView);
        }
        return list;
    }
}
