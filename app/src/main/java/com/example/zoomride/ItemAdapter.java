package com.example.zoomride;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.zoomride.ItemAdapter.ItemHolder;

public class ItemAdapter extends Adapter<ItemHolder> {

    public static class ItemHolder extends ViewHolder {

        public ItemHolder(View itemView) {
            super(itemView);
        }

        public void setData(String name) {}
    }

    private MovePOJO move;
    private int type;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = new View(parent.getContext());
            view.setLayoutParams(new LayoutParams(10, 0));
            view.setBackgroundResource(R.color.item_bg);
            return new ItemHolder(view);
        } else {
            switch (this.type) {
                case 0:
                    return new ItemHolder(
                        LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.ads_cell, null));
                case 1:
                    return new ItemHolder(
                        LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.deliveries_cell, null));
                case 2:
                    return new ItemHolder(
                        LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.items_cell, null));
                default:
                    return new ItemHolder(
                        LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.junks_cell, null));
            }
        }
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ItemHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            holder.setData(move.getItem(type).get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return move != null && move.getItem(type) != null ? move.getItem(type).size() + 2 : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 || position == getItemCount() - 1 ? 0 : 1;
    }

    public void setData(MovePOJO move, int position) {
        this.type = position;
        this.move = move;
    }


}
