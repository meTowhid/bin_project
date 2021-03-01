package com.nibri.binproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.nibri.binproject.adapters.StoryPagerAdapter;

public class StoryActivity extends AppCompatActivity {
    StoryPagerAdapter storyPagerAdapter;
    ViewPager viewPager;
    boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        viewPager = findViewById(R.id.viewpager);
        setupViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isFirstTime) {
            int startIndex = getIntent().getIntExtra("itemIndex", 0);
            viewPager.setCurrentItem(startIndex);
            storyPagerAdapter.loadPage(startIndex);
            isFirstTime = false;
        }
    }

    void setupViewPager() {
        storyPagerAdapter = new StoryPagerAdapter(getSupportFragmentManager(), DummyData.storyData(), (boolean isForeword) -> {
            boolean isFirst = viewPager.getCurrentItem() == 0;
            boolean isLast = viewPager.getCurrentItem() == DummyData.storyData().size() - 1;
            if ((isFirst && !isForeword) || (isLast && isForeword)) finish();
            else {
                int newIndex = viewPager.getCurrentItem() + (isForeword ? 1 : -1);
                viewPager.setCurrentItem(newIndex, true);
                storyPagerAdapter.loadPage(newIndex);
            }
        });
        viewPager.setAdapter(storyPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                storyPagerAdapter.loadPage(position);
            }
        });
    }
}
