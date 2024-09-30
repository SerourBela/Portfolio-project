package com.serour.ranamaeak;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serour.ranamaeak.model.seancetraitements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SeanceAdapter extends RecyclerView.Adapter<SeanceAdapter.MyViewHolder> implements Filterable {

    private List<seancetraitements> seanceList;
    private List<seancetraitements> seanceSearchList;

    SeanceAdapter(List<seancetraitements> seanceList) {
        this.seanceList = seanceList;
        seanceSearchList = new ArrayList<>(seanceList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        seancetraitements currentItem = seanceList.get(position);
        String pattern = "yyyy/MM/dd";
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat(pattern);
        holder.date.setText (currentItem.getDate());
        holder.commentaire.setText(currentItem.getCommentaire());
        holder.conseils.setText(currentItem.getConseils());

    }

    @Override
    public int getItemCount() {
        return seanceList.size();
    }

    @Override
    public Filter getFilter() {
        return eventFilter;
    }

    private Filter eventFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<seancetraitements> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(seanceSearchList);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (seancetraitements item : seanceSearchList) {
                    if (item.getCommentaire().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            seanceList.clear();
            seanceList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, commentaire, conseils;

        MyViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            commentaire = itemView.findViewById(R.id.comment);
            conseils = itemView.findViewById(R.id.conseil);


        }
    }
}