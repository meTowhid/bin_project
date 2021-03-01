package com.nibri.binproject.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.nibri.binproject.R;
import com.nibri.binproject.model.CouponData;
import com.nibri.binproject.utils.Utils;

import java.util.List;

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolderCoupon> {

    private final List<CouponData> couponList;

    public HorizontalRecyclerAdapter(List<CouponData> couponList) {
        this.couponList = couponList;
    }

    @NonNull
    @Override
    public ViewHolderCoupon onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coupon_tile, parent, false);
        return new ViewHolderCoupon(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolderCoupon holder, final int position) {
        CouponData c = couponList.get(position);
        holder.serviceName.setText(c.service);
        holder.title.setText(c.title);
        Utils.setHtml(holder.info, c.info);
        holder.code.setText(c.code.toUpperCase());

        setOnTapDrawable(holder.serviceName);
        holder.code.setOnClickListener(v -> Utils.copyCode(holder.itemView.getContext(), c.code.toUpperCase()));

    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnTapDrawable(TextView view) {
        view.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (view.getRight() - view.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    TooltipCompat.setTooltipText(v, "Tooltip here!");
                    return true;
                }
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    public static class ViewHolderCoupon extends RecyclerView.ViewHolder {
        TextView serviceName, title, info, code;

        public ViewHolderCoupon(View view) {
            super(view);
            serviceName = view.findViewById(R.id.tv_service_name);
            title = view.findViewById(R.id.tv_title);
            info = view.findViewById(R.id.tv_info);
            code = view.findViewById(R.id.tv_code);
        }
    }

}
