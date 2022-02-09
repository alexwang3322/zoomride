package com.example.zoomride;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.zoomride.MoveListAdapter.MoveListHolder;

public class MoveListAdapter extends Adapter<MoveListHolder> {

    public static class MoveListHolder extends ViewHolder {

        private TextView titleView;
        private RecyclerView contentView;

        public MoveListHolder(View itemView) {
            super(itemView);
            DividerItemDecoration divider =
                new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.HORIZONTAL);
            divider.setDrawable(itemView.getResources().getDrawable(
                R.drawable.main_list_horizatonal_divider));
            LinearLayoutManager llm = new LinearLayoutManager(itemView.getContext());
            llm.setOrientation(RecyclerView.HORIZONTAL);
            titleView = itemView.findViewById(R.id.title);
            contentView = itemView.findViewById(R.id.content);
            contentView.setLayoutManager(llm);
            contentView.addItemDecoration(divider, 0);
        }

        public void setData(MovePOJO move, int position) {
            ItemAdapter adapter = new ItemAdapter();
            adapter.setData(move, position);
            contentView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            titleView.setText(move.getTitle(position));
        }
    }

    private MovePOJO move;

    @Override
    public MoveListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
            parent.getContext()).inflate(R.layout.main_list_item, null);
        if (viewType == 0) {
            view.setBackgroundResource(R.drawable.main_list_firstitem_conern_background);
        }
        MoveListHolder holder = new MoveListHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MoveListHolder holder, int position) {
        holder.setData(move, position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return move == null ? 0 : move.count();
    }

    public void setData(MovePOJO move) {
        this.move = move;
    }
}
