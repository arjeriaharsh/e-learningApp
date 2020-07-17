package com.harsharjeria.courseapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.harsharjeria.courseapp.Models.Classes;
import com.harsharjeria.courseapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotTopicsAdap extends RecyclerView.Adapter<HotTopicsAdap.WebsiteListsViewHolder> {

    private Classes[] listdata;
    private Context context;

    public HotTopicsAdap(Context context, Classes[] listdata) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public WebsiteListsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_hot_topics, parent, false);
        return new WebsiteListsViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull WebsiteListsViewHolder holder, int position) {
        holder.textView.setText(listdata[position].nameclass);
  }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class WebsiteListsViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public WebsiteListsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textHot);
            this.imageView = itemView.findViewById(R.id.iconId);
        }
    }
}
