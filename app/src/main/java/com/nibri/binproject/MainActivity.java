package com.nibri.binproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
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
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecoration(Utils.dpToPixel(this, 16)));
    }
}
