package com.serour.ranamaeak;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serour.ranamaeak.model.notifications;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private List<notifications> notificationList;

    NotificationAdapter(List<notifications> notificationList) {
        this.notificationList = notificationList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_notification, parent, false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        notifications currentItem = notificationList.get(position);
        String pattern = "yyyy/MM/dd";
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat(pattern);
        holder.date.setText (df.format(currentItem.getDate()));
        holder.detailnoti.setText(currentItem.getDetail());
    }
    @Override
    public int getItemCount() {
        return notificationList.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, detailnoti;

        MyViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            detailnoti = itemView.findViewById(R.id.detailnoti);
        }
    }
}