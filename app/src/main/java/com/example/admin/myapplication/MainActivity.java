package com.example.admin.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.myapplication.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private int mCurrentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildDatas();
        mViewPager = findViewById(R.id.viewPager);

        MyAdapter adapter = new MyAdapter();
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (mCurrentPosition == 0) {
                            mCurrentPosition = 3;
                            mViewPager.setCurrentItem(mCurrentPosition,false);
                        } else if (mCurrentPosition == 4) {
                            mCurrentPosition = 1;
                            mViewPager.setCurrentItem(mCurrentPosition,false);
                        }
                        break;
                }
            }
        });


    }


    private List<Integer> datas;

    public List<Integer> buildDatas() {
        datas = new ArrayList<>();

        datas.add(R.drawable.a);
        datas.add(R.drawable.b);
        datas.add(R.drawable.c);

        datas.add(0, datas.get(datas.size() - 1));
        datas.add(datas.get(1));

        return datas;


    }


    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return  datas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Integer ids = datas.get(position);
            View rootView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
            ImageView imageView = rootView.findViewById(R.id.image);
            imageView.setImageResource(ids);
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
