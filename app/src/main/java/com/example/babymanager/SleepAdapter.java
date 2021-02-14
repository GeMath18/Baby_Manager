package com.example.babymanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SleepAdapter extends RecyclerView.Adapter<SleepAdapter.ViewHolder> {

    private List<SleepData> dataList;
    private Activity context;
    private RoomDBSleep database;

    public SleepAdapter(Activity context, List<SleepData> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SleepAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sleep_list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SleepAdapter.ViewHolder holder, int position) {

//        SleepData data = dataList.get(position);

        TextView sleepStart_dt_label = holder.itemView.findViewById(R.id.sleepStart_dt_label);
        TextView sleepEnd_dt_label = holder.itemView.findViewById(R.id.sleepEnd_dt_label);
        sleepStart_dt_label.setText(dataList.get(position).getStart_time());
        sleepEnd_dt_label.setText(dataList.get(position).getStop_time());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView startTimeText, stopTimeText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            startTimeText = itemView.findViewById(R.id.sleepStart_dt_label);
            stopTimeText = itemView.findViewById(R.id.sleepEnd_dt_label);

        }
    }
}
