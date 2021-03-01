package com.nibri.binproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nibri.binproject.R;
import com.nibri.binproject.model.StoryData;

import java.util.List;

public class StoryRecyclerAdapter extends RecyclerView.Adapter<StoryRecyclerAdapter.ViewHolderStory> {

    private final List<StoryData> stories;
    private final Callback callback;

    public StoryRecyclerAdapter(List<StoryData> stories, Callback callback) {
        this.stories = stories;
        this.callback = callback;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStory holder, int position, @NonNull List<Object> payloads) {
        holder.buildProgressIndicators(holder.itemView, stories.get(position).images.size());
        super.onBindViewHolder(holder, position, payloads);
    }

    @NonNull
    @Override
    public ViewHolderStory onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolderStory(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolderStory holder, final int position) {
        StoryData story = stories.get(position);
        holder.textView.setText(story.title);
        holder.itemView.setOnClickListener(v -> callback.onTapStory(position));
        Glide.with(holder.itemView.getContext()).load(story.images.get(0)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class ViewHolderStory extends RecyclerView.ViewHolder {
        private final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f);

        ImageView imageView;
        TextView textView;

        public ViewHolderStory(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }

        public void buildProgressIndicators(View view, int count) {
            LinearLayout progressViewHolder = view.findViewById(R.id.ll_progress);
            if (count == 0) progressViewHolder.setVisibility(View.INVISIBLE);
            else for (int i = 0; i < count; i++) {
                View pbView = LayoutInflater.from(view.getContext()).inflate(R.layout.view_story_progress, null, false);
                ((ProgressBar) pbView.findViewById(R.id.pb)).setProgress(100);
                pbView.setLayoutParams(params);
                progressViewHolder.addView(pbView);
            }
        }
    }

    public interface Callback {
        void onTapStory(int index);
    }
}
