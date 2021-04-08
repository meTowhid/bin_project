package com.nibri.binproject.adapters;

import android.view.LayoutInflater;
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
    private final boolean enableExpandedFeature;
    private boolean isExpanded = false;
    private final int blocCount, expandItemPosition;
    List<Datum> serviceLists;

    public ServiceListAdapter(List<Datum> serviceLists, int row, int column) {
        this.blocCount = row * column;
        this.expandItemPosition = blocCount - 1;
        this.enableExpandedFeature = serviceLists.size() > blocCount;
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
        if (enableExpandedFeature && !isExpanded && position == expandItemPosition) {
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.ic_more)
                    .into(holder.binding.ivIcon);
        } else if (enableExpandedFeature && isExpanded && position == serviceLists.size()) {
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.ic_less)
                    .into(holder.binding.ivIcon);
        } else {
            Glide.with(holder.itemView.getContext())
                    .load(serviceLists.get(position).getServiceIcon().getUrl())
                    .into(holder.binding.ivIcon);
        }

        holder.binding.ivIcon.setOnClickListener(v -> {
            if (enableExpandedFeature && (position == expandItemPosition) && !isExpanded) {
                // expand list here
                System.out.println("expanding");
                isExpanded = true;
                notifyItemChanged(expandItemPosition);
            } else if (enableExpandedFeature && position == serviceLists.size() && isExpanded) {
                // shrink list here
                System.out.println("shrinking");
                isExpanded = false;
                notifyItemRangeChanged(expandItemPosition, serviceLists.size() + 1 - expandItemPosition);
            } else {
                // default callback here
            }
        });
    }

    @Override
    public int getItemCount() {
        return enableExpandedFeature ? (isExpanded ? (serviceLists.size() + 1) : blocCount) : serviceLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemServicelistBinding binding;

        public ViewHolder(ItemServicelistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
