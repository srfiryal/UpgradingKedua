package com.example.upgradingkedua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private ArrayList<RestaurantModel> dataList;
    private Context mContext;
    private OnItemClickListener listener;

    public RestaurantAdapter(ArrayList<RestaurantModel> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.restaurant_list, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        holder.img_logo.setImageResource(dataList.get(position).getImage());
        holder.tv_name.setText(dataList.get(position).getName());
        holder.tv_address.setText(dataList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_address;
        private ImageView img_logo;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            img_logo = itemView.findViewById(R.id.img_logo);
            cardView = itemView.findViewById(R.id.card_layout);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
