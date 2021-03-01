package com.nibri.binproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nibri.binproject.adapters.StoryRecyclerAdapter;
import com.nibri.binproject.utils.HorizontalSpaceItemDecoration;
import com.nibri.binproject.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

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


        StoryRecyclerAdapter storyAdapter = new StoryRecyclerAdapter(DummyData.storyDataFromJson(), (index) -> {
            System.out.println("index: " + index);
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("itemIndex", index);
            startActivity(intent);
        });
        recyclerView2.setAdapter(storyAdapter);
        recyclerView2.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));
    }

/*    private void showStoryDialog(int index) {
        View view = getLayoutInflater().inflate(R.layout.dialog_view_story, null);
        AlertDialog.Builder dialogView = new AlertDialog.Builder(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialogView.setView(view);

        ViewPager vp = view.findViewById(R.id.viewpager);

        dialogView.create().show();

        setupViewPager(vp, index);
    }*/
}
