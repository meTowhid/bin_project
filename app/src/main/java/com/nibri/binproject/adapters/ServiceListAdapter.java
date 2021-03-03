package com.nibri.binproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nibri.binproject.R;
import com.nibri.binproject.databinding.ItemServicelistBinding;
import com.nibri.binproject.model.response.Datum;

import java.util.List;

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.ViewHolder> {

    List<Datum> serviceLists;
    Context context;
    private static final String TAG = "ServiceListAdapter";

    public ServiceListAdapter(List<Datum> serviceLists) {
        this.serviceLists = serviceLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemServicelistBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_servicelist, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Log.v(TAG, "ICON: " + serviceLists.get(position).getServiceIcon().getUrl());
        if (serviceLists.get(position).isMoreAvailable()) {
            holder.binding.AppCompatImageViewServiceMore.setVisibility(View.VISIBLE);
        }

        Glide.with(holder.itemView.getContext())
                .load(serviceLists.get(position).getServiceIcon().getUrl())
                .into(holder.binding.AppCompatImageViewService);

    }

    @Override
    public int getItemCount() {
        return serviceLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemServicelistBinding binding;

        public ViewHolder(ItemServicelistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
