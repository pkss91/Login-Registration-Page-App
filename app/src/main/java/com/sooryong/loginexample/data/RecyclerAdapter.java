
package com.sooryong.loginexample.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sooryong.loginexample.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private Context c;
    private List<HistoryData> dataList;

    public RecyclerAdapter(Context c, List<HistoryData> dataList) {
        this.c = c;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.activity_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        holder.id.setText(dataList.get(position).getSensorID());
        holder.type.setText("" + dataList.get(position).getEventType());
        holder.date.setText("" + dataList.get(position).getEventDate());

    }

    @Override
    public int getItemCount() {
        return (dataList == null) ? 0 : dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView type;
        TextView date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.sensorID);
            type = (TextView)itemView.findViewById(R.id.eventType);
            date = (TextView)itemView.findViewById(R.id.eventDate);

        }
    }
}