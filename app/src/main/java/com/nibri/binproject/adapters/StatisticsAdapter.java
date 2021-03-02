package com.nibri.binproject.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nibri.binproject.R;
import com.nibri.binproject.databinding.ItemStatBinding;
import com.nibri.binproject.model.response.Datum;

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

        holder.binding.itemTitle.setText(Html.fromHtml(data.get(position).getTitle()));
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getImage() != null ? data.get(position).getImage().getUrl() : R.drawable.ic_baseline_cloud)
                .into(holder.binding.itemImage);
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
