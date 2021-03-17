package com.desigggggnn.firstone.Adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.desigggggnn.firstone.R;

import java.util.ArrayList;
import java.util.Timer;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;


    public ViewPagerAdapter(Context context,ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.custom_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);


        imageView.setImageResource(IMAGES.get(position));

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}








//    final Handler handler = new Handler();
//    public Timer swipeTimer ;
//    private Context context;
//    private LayoutInflater layoutInflater;
//    private Integer [] images = {R.drawable.facebook,R.drawable.twitter,R.drawable.facebook};
//
//    public ViewPagerAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//
//        return images.length;
//    }
//
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, final int position) {
//
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.custom_layout, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
//        imageView.setImageResource(images[position]);
//
//
//        ViewPager vp = (ViewPager) container;
//        vp.addView(view, 0);
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//        ViewPager vp = (ViewPager) container;
//        View view = (View) object;
//        vp.removeView(view);
//
//    }
//}