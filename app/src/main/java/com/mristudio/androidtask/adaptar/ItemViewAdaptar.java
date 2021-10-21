package com.mristudio.androidtask.adaptar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mristudio.androidtask.DetailsActivity;
import com.mristudio.androidtask.R;
import com.mristudio.androidtask.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemViewAdaptar extends RecyclerView.Adapter<ItemViewAdaptar.ItemViewHoalder> {
    List<ItemModel> itemModelList = new ArrayList<>();
    Context context;

    public ItemViewAdaptar(Context context) {
        this.context = context;
    }

    public void setItemViewAdaptar(List<ItemModel> itemModelList) {
        this.itemModelList = itemModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewAdaptar.ItemViewHoalder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ItemViewHoalder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewAdaptar.ItemViewHoalder holder, int position) {

        holder.tittle.setText(itemModelList.get(position).getTittle());
        holder.description.setText(itemModelList.get(position).getDescription());
        holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("model", itemModelList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class ItemViewHoalder extends RecyclerView.ViewHolder {
        TextView tittle, description;
        ConstraintLayout itemClick;

        public ItemViewHoalder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.tittle);
            description = itemView.findViewById(R.id.description);
            itemClick = itemView.findViewById(R.id.itemClick);
        }
    }
}
