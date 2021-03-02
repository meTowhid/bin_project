package com.nibri.binproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.nibri.binproject.adapters.HorizontalRecyclerAdapter;
import com.nibri.binproject.adapters.ServiceListAdapter;
import com.nibri.binproject.adapters.StatisticsAdapter;
import com.nibri.binproject.adapters.StoryRecyclerAdapter;
import com.nibri.binproject.databinding.ActivityMainBinding;
import com.nibri.binproject.model.response.Datum;
import com.nibri.binproject.model.response.HomeConfig;
import com.nibri.binproject.utils.HorizontalSpaceItemDecoration;
import com.nibri.binproject.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();
        initCouponView();
        initMileStoneView();
        initServiceList();

    }

    private void initServiceList() {

        List<Datum> list;
        list = getData("grid");

        if (list.size() >= 6) {
            list.add(getMoreVertical());
        }

        Log.v(TAG, "list size : "+list.size());


        binding.recyclerViewMileStone.setLayoutManager(new GridLayoutManager(this, 4));
        binding.recyclerViewMileStone.setAdapter(new ServiceListAdapter(list));
    }


    private void initMileStoneView() {
        binding.recyclerViewMileStone.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewMileStone.setAdapter(new StatisticsAdapter(getData("milestone")));
        binding.recyclerViewMileStone.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));
    }

    private void initCouponView() {

        binding.recyclerViewCoupon.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewCoupon.setAdapter(new HorizontalRecyclerAdapter(getData("coupon")));
        binding.recyclerViewCoupon.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));

    }

    private void initRecyclerView() {
        binding.recyclerViewStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        StoryRecyclerAdapter storyAdapter = new StoryRecyclerAdapter(DummyData.storyDataFromJson(), (index) -> {
            System.out.println("index: " + index);
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("itemIndex", index);
            startActivity(intent);
        });
        binding.recyclerViewStories.setAdapter(storyAdapter);
        binding.recyclerViewStories.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));

    }

  /*    private void showStoryDialog(int index) {
        View view = getLayoutInflater().inflate(R.layout.dialog_view_story, null);
        AlertDialog.Builder dialogView = new AlertDialog.Builder(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialogView.setView(view);

        ViewPager vp = view.findViewById(R.id.viewpager);

        dialogView.create().show();

        setupViewPager(vp, index);
    }*/


    /*LOADING LOCAL JSON*/
    public HomeConfig loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("homeConfig.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return new Gson().fromJson(json, HomeConfig.class);
    }

    List<Datum> getData(String tag) {
        List<Datum> list = new ArrayList<>();
        if (tag.equalsIgnoreCase("coupon")) {
            for (int i = 0; i < loadJSONFromAsset().getHomePageLayout().size(); i++) {
                if (loadJSONFromAsset().getHomePageLayout().get(i).getType().equalsIgnoreCase("coupon")) {
                    for (int j = 0; j < loadJSONFromAsset().getHomePageLayout().get(i).getData().size(); j++) {
                        list.add(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j));
                    }
                }
            }
        } else if (tag.equalsIgnoreCase("milestone")) {
            for (int i = 0; i < loadJSONFromAsset().getHomePageLayout().size(); i++) {
                if (loadJSONFromAsset().getHomePageLayout().get(i).getType().equalsIgnoreCase("milestone")) {
                    for (int j = 0; j < loadJSONFromAsset().getHomePageLayout().get(i).getData().size(); j++) {
                        list.add(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j));
                    }
                }
            }
        } else if (tag.equalsIgnoreCase("grid")) {
            for (int i = 0; i < loadJSONFromAsset().getHomePageLayout().size(); i++) {
                if (loadJSONFromAsset().getHomePageLayout().get(i).getType().equalsIgnoreCase("grid")) {
                    for (int j = 0; j < loadJSONFromAsset().getHomePageLayout().get(i).getData().size(); j++) {
                        list.add(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j));
                    }
                }
            }
        }

        Log.v(TAG, "list size in loop: "+list.size());
        return list;
    }

    Datum getMoreVertical() {
        Datum model = new Datum();

        model.setMoreAvailable(true);

        return model;
    }
}
