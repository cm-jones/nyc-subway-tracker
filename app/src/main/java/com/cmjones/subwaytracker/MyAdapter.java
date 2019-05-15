package com.cmjones.subwaytracker;

import com.cmjones.subwaytracker.lib.*;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Train> arrivals;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    MyAdapter(Context context, List<Train> setArrivals) {
        layoutInflater = LayoutInflater.from(context);
        arrivals = setArrivals;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Train train = getTrain(position);
        Service service = train.getService();
        holder.direction.setText(train.getDirection());
        holder.destination.setText(train.getDestination());
        if (service.equals(Service.A)) {
            holder.bullet.setImageResource(R.drawable.ic_a_circle);
        } else if (service.equals(Service.N)) {
            holder.bullet.setImageResource(R.drawable.ic_n_circle);
        } else if (service.equals(Service.FOUR)) {
            holder.bullet.setImageResource(R.drawable.ic_4_circle);
        } else if (service.equals(Service.FIVE)) {
            holder.bullet.setImageResource(R.drawable.ic_5_circle);
        } else if (service.equals(Service.SIX)) {
            holder.bullet.setImageResource(R.drawable.ic_6_circle);
        } else if (service.equals(Service.SEVEN)) {
            holder.bullet.setImageResource(R.drawable.ic_7_circle);
        }
    }

    /**
     * Get the total number of train objects.
     *
     * @return the number of trains
     */
    @Override
    public int getItemCount() {
        return arrivals.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView bullet;
        TextView direction;
        TextView destination;
        TextView arrivalTime;

        ViewHolder(View itemView) {
            super(itemView);
            direction = itemView.findViewById(R.id.direction);
            destination = itemView.findViewById(R.id.destination);
            bullet = itemView.findViewById(R.id.bullet);
            arrivalTime = itemView.findViewById(R.id.arrivalTime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    // Convenience method for getting train at click position
    Train getTrain(int position) {
        return arrivals.get(position);
    }

    // Allows clicks events to be caught
    void setClickListener(ItemClickListener setItemClickListener) {
        itemClickListener = setItemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
