package com.example.babymanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaperAdapter extends RecyclerView.Adapter<DiaperAdapter.ViewHolder> {

    private List<DiaperData> dataList;
    private Activity context;
    private RoomDBDiaper database;

    public DiaperAdapter(Activity context,List<DiaperData> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiaperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diaper_list_row,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DiaperAdapter.ViewHolder holder, int position) {

//        DiaperData data = dataList.get(position);
//        database = RoomDBDiaper.getInstance(context);
//
//        holder.dateTimeText.setText(data.getDatetime());
//        holder.statusText.setText(data.getSpinner());

        TextView diaper_dt_label = holder.itemView.findViewById(R.id.diaper_dt_label);
        TextView status_label = holder.itemView.findViewById(R.id.status_label);
        diaper_dt_label.setText(dataList.get(position).getDatetime());
        status_label.setText(dataList.get(position).getSpinner());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateTimeText, statusText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateTimeText = itemView.findViewById(R.id.diaper_dt_label);
            statusText = itemView.findViewById(R.id.status_label);
        }
    }
}
