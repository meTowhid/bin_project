package com.nibri.binproject.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int space;

    public HorizontalSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int index = parent.getChildAdapterPosition(view);
        if (index == 0) outRect.left = space; // starting space
        else if (index == Objects.requireNonNull(parent.getAdapter()).getItemCount() - 1)
            outRect.right = space; // ending space
    }
}

