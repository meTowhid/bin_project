package com.nibri.binproject;

import com.nibri.binproject.adapters.WeightWatchersCludAdapter;
import com.nibri.binproject.model.response.ServiceUnavailableIcon;
import com.nibri.binproject.model.response.ServiceIcon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    ServiceListAdapter adapter;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();
        initCouponView();
        initMileStoneView();
        initServiceList();
        initWatcher();
        getTotalVerticals();

    }

    private void initWatcher() {
        binding.recyclerViewWatcher.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewWatcher.setAdapter(new WeightWatchersCludAdapter(getData("watcher_club")));
        binding.recyclerViewWatcher.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));
    }

    private void initServiceList() {
            binding.recyclerViewServiceList.setLayoutManager(new GridLayoutManager(this, 4));
            binding.recyclerViewServiceList.setAdapter(new ServiceListAdapter(getTotalVerticals()));
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
        } else if (tag.equalsIgnoreCase("watcher_club")) {
            for (int i = 0; i < loadJSONFromAsset().getHomePageLayout().size(); i++) {
                if (loadJSONFromAsset().getHomePageLayout().get(i).getType().equalsIgnoreCase("watcher_club")) {
                    for (int j = 0; j < loadJSONFromAsset().getHomePageLayout().get(i).getData().size(); j++) {
                        list.add(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j));
                    }
                }
            }
            //getLessVertical();
        }

        Log.v(TAG, "list size in loop: " + list.size());
        return list;
    }

    List<Datum> getTotalVerticals() {
        List<Datum> list = new ArrayList<>();

        for (int i = 0; i < loadJSONFromAsset().getHomePageLayout().size(); i++) {
            if (loadJSONFromAsset().getHomePageLayout().get(i).getType().equalsIgnoreCase("grid")) {
                for (int j = 0; j < loadJSONFromAsset().getHomePageLayout().get(i).getData().size(); j++) {
                    list.add(new Datum(
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceName(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getIsServiceAvailable(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceType(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceHTTPHeader(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getIsAuthRequired(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceScope(),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceURL(),
                            new ServiceIcon(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceIcon().getUrl()),
                            new ServiceUnavailableIcon(loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceUnavailableIcon().getUrl()),
                            loadJSONFromAsset().getHomePageLayout().get(i).getData().get(j).getServiceUnavailableMsg()));
                }
            }
        }
        return list;
    }

    List<Datum> getVerticalsWithMore(int count, List<Datum> totalVerticals) {
        List<Datum> list = new ArrayList<>();
        for (int j = 0; j <= count; j++) {
            list.add(new Datum(
                    totalVerticals.get(j).getServiceName(),
                    totalVerticals.get(j).getIsServiceAvailable(),
                    totalVerticals.get(j).getServiceType(),
                    totalVerticals.get(j).getServiceHTTPHeader(),
                    totalVerticals.get(j).getIsAuthRequired(),
                    totalVerticals.get(j).getServiceScope(),
                    totalVerticals.get(j).getServiceURL(),
                    new ServiceIcon(totalVerticals.get(j).getServiceIcon().getUrl()),
                    new ServiceUnavailableIcon(totalVerticals.get(j).getServiceUnavailableIcon().getUrl()),
                    totalVerticals.get(j).getServiceUnavailableMsg(), false));

            Log.v(TAG, "In Loop :" + j);
        }

        list.add(new Datum(
                "",
                true,
                "",
                "",
                false,
                "",
                "",
                new ServiceIcon("100"),
                new ServiceUnavailableIcon(""),
                "",
                true));


        return list;
    }
}
