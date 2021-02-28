package com.nibri.binproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    ViewPager viewPager;
    StoryPagerAdapter storyPagerAdapter;

    private void initRecyclerView() {
        /*RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<CouponData> couponData = new ArrayList<>();
        couponData.add(new CouponData("food", "৳100 Off", "On your first order with <font color=#ffffff><b>bKAsh</b></font> payment", "Bijoy21"));
        couponData.add(new CouponData("bus", "25% Off", "On your first order with <font color=#ffffff><b>bKAsh</b></font> payment", "Bijoy21"));
        couponData.add(new CouponData("lunch", "৳100 Off", "On your first order with <font color=#ffffff><b>bKAsh</b></font> payment", "Bijoy21"));
        couponData.add(new CouponData("bus", "৳100 Off", "On your first order with <font color=#ffffff><b>bKAsh</b></font> payment", "Bijoy21"));
        couponData.add(new CouponData("bus", "৳100 Off", "On your first order with <font color=#ffffff><b>bKAsh</b></font> payment", "Bijoy21"));

        HorizontalRecyclerAdapter couponAdapter = new HorizontalRecyclerAdapter(couponData);
        recyclerView.setAdapter(couponAdapter);
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));*/


        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);


        viewPager = findViewById(R.id.viewpager);
        storyPagerAdapter = new StoryPagerAdapter(getSupportFragmentManager(), getStoryData(), this::autoScrollViewPager);
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

        StoryRecyclerAdapter storyAdapter = new StoryRecyclerAdapter(getStoryData(), (index) -> {
            System.out.println("index: " + index);
            viewPager.setCurrentItem(index);
        });
        recyclerView2.setAdapter(storyAdapter);
        recyclerView2.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));
    }

    private void autoScrollViewPager(boolean isForeword) {
        if (viewPager.getCurrentItem() < getStoryData().size() - 1 && isForeword) {
            int newIndex = viewPager.getCurrentItem() + 1;
            viewPager.setCurrentItem(newIndex, true);
            storyPagerAdapter.loadPage(newIndex);
        }

        // else viewPager.setCurrentItem(0);
    }

    private List<StoryData> getStoryData() {
        String[] imageUrls = new String[]{
                "https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/10/10/15/28/butterfly-2837589_960_720.jpg"
        };

        List<String> threeImages = new ArrayList<>();
        threeImages.add(imageUrls[0]);
        threeImages.add(imageUrls[1]);
        threeImages.add(imageUrls[2]);
        List<String> twoImages = new ArrayList<>();
        twoImages.add(imageUrls[3]);
        twoImages.add(imageUrls[4]);
        List<String> oneImages = new ArrayList<>();
        oneImages.add(imageUrls[0]);

        List<StoryData> storyData = new ArrayList<>();
        storyData.add(new StoryData("Something Special About - Food", threeImages));
        storyData.add(new StoryData("Something Special About - Bus", twoImages));
        storyData.add(new StoryData("Something Special About - Lunch", oneImages));
        storyData.add(new StoryData("Something Special About - Bus", threeImages));
        storyData.add(new StoryData("Something Special About - Bus", twoImages));

        return storyData;
    }
}
