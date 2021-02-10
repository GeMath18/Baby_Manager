package com.example.babymanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

    private List<Bottle> list;
    private Activity context;
    private RoomDBClass roomDBClass;

    public RecyclerAdapter(Activity context, List<Bottle>list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        holder.dateTimeText.setText ( list.get(position).getDatetime());
        holder.amountText.setText(list.get(position).getAmount());
        holder.bSpinnerText.setText(list.get(position).getSpinner());


        
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView dateTimeText, amountText, bSpinnerText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TextView dateTimeText = itemView.findViewById(R.id.label_1);
            TextView amountText = itemView.findViewById(R.id.label_2);
            TextView bSpinnerText = itemView.findViewById(R.id.label_3);
        }
    }
}
