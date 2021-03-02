package com.nibri.binproject.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nibri.binproject.R;
import com.nibri.binproject.databinding.ItemStatBinding;
import com.nibri.binproject.model.milestone.Datum;

import java.util.ArrayList;
import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolderStatistics> {

    List<Datum> data = new ArrayList<Datum>();

    public StatisticsAdapter(List<Datum> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolderStatistics onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStatBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_stat, parent, false);
        return new ViewHolderStatistics(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStatistics holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolderStatistics extends RecyclerView.ViewHolder {
        ItemStatBinding binding;

        public ViewHolderStatistics(ItemStatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
