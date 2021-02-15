package com.example.babymanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NapAdapter extends RecyclerView.Adapter<NapAdapter.ViewHolder> {

    private List<NapData> dataList;
    private Activity context;
    private RoomDBNap database;

    public NapAdapter(Activity context, List<NapData> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public NapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nap_list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NapAdapter.ViewHolder holder, int position) {

        TextView start_nap_label = holder.itemView.findViewById(R.id.start_nap_label);
        TextView end_nap_label = holder.itemView.findViewById(R.id.end_nap_label);
        start_nap_label.setText(dataList.get(position).getStart_nap());
        end_nap_label.setText(dataList.get(position).getStop_nap());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView startNapTimeText, stopNapTimeText;

        public ViewHolder(View itemView) {
            super(itemView);

            startNapTimeText = itemView.findViewById(R.id.start_nap_label);
            stopNapTimeText = itemView.findViewById(R.id.end_nap_label);
        }
    }
}
