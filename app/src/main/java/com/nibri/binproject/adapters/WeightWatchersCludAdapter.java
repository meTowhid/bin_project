package com.nibri.binproject.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nibri.binproject.R;
import com.nibri.binproject.databinding.ItemWwClubBinding;
import com.nibri.binproject.model.response.Datum;

import java.util.ArrayList;
import java.util.List;

public class WeightWatchersCludAdapter extends RecyclerView.Adapter<WeightWatchersCludAdapter.ViewHolderWatcherClub> {

    List<Datum> data = new ArrayList<Datum>();

    public WeightWatchersCludAdapter(List<Datum> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public WeightWatchersCludAdapter.ViewHolderWatcherClub onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWwClubBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_ww_club, parent, false);
        return new ViewHolderWatcherClub(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWatcherClub holder, int position) {

        holder.binding.itemTitle.setText(data.get(position).getTitle());
        holder.binding.itemRestaurantName.setText(data.get(position).getSubTitle());
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getImage() != null ? data.get(position).getImage().getUrl() : R.drawable.ic_baseline_cloud)
                .into(holder.binding.banner);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolderWatcherClub extends RecyclerView.ViewHolder {
        ItemWwClubBinding binding;

        public ViewHolderWatcherClub(ItemWwClubBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
