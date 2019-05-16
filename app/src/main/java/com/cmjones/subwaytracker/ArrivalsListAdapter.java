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

public class ArrivalsListAdapter extends RecyclerView.Adapter<ArrivalsListAdapter.ViewHolder> {
    private List<Train> arrivals;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    ArrivalsListAdapter(Context context, List<Train> setArrivals) {
        layoutInflater = LayoutInflater.from(context);
        arrivals = setArrivals;
    }

    /**
     * Inflate the row layout from xml when needed
     *
     * @param parent the parent
     * @param viewType the viewType
     * @return the return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binds the data to the TextView in each row
     *
     * @param holder the holder
     * @param position the position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Train train = getTrain(position);
        Service service = train.getService();
        holder.direction.setText(train.getDirection());
        holder.destination.setText(train.getDestination());
        if (service.equals(Service.ONE)) {
            holder.bullet.setImageResource(R.drawable.ic_1_circle);
        } else if (service.equals(Service.TWO)) {
            holder.bullet.setImageResource(R.drawable.ic_2_circle);
        } else if (service.equals(Service.THREE)) {
            holder.bullet.setImageResource(R.drawable.ic_3_circle);
        } else if (service.equals(Service.FOUR)) {
            holder.bullet.setImageResource(R.drawable.ic_4_circle);
        } else if (service.equals(Service.FIVE)) {
            holder.bullet.setImageResource(R.drawable.ic_5_circle);
        } else if (service.equals(Service.SIX)) {
            holder.bullet.setImageResource(R.drawable.ic_6_circle);
        } else if (service.equals(Service.SEVEN)) {
            holder.bullet.setImageResource(R.drawable.ic_7_circle);
        } else if (service.equals(Service.A)) {
            holder.bullet.setImageResource(R.drawable.ic_a_circle);
        } else if (service.equals(Service.B)) {
            holder.bullet.setImageResource(R.drawable.ic_b_circle);
        } else if (service.equals(Service.C)) {
            holder.bullet.setImageResource(R.drawable.ic_c_circle);
        } else if (service.equals(Service.D)) {
            holder.bullet.setImageResource(R.drawable.ic_d_circle);
        } else if (service.equals(Service.E)) {
            holder.bullet.setImageResource(R.drawable.ic_e_circle);
        } else if (service.equals(Service.F)) {
            holder.bullet.setImageResource(R.drawable.ic_f_circle);
        } else if (service.equals(Service.G)) {
            holder.bullet.setImageResource(R.drawable.ic_g_circle);
        } else if (service.equals(Service.J)) {
            holder.bullet.setImageResource(R.drawable.ic_j_circle);
        } else if (service.equals(Service.L)) {
            holder.bullet.setImageResource(R.drawable.ic_l_circle);
        } else if (service.equals(Service.M)) {
            holder.bullet.setImageResource(R.drawable.ic_m_circle);
        } else if (service.equals(Service.N)) {
            holder.bullet.setImageResource(R.drawable.ic_n_circle);
        } else if (service.equals(Service.Q)) {
            holder.bullet.setImageResource(R.drawable.ic_q_circle);
        } else if (service.equals(Service.R)) {
            holder.bullet.setImageResource(R.drawable.ic_r_circle);
        } else if (service.equals(Service.S)) {
            holder.bullet.setImageResource(R.drawable.ic_s_circle);
        } else if (service.equals(Service.W)) {
            holder.bullet.setImageResource(R.drawable.ic_w_circle);
        } else if (service.equals(Service.Z)) {
            holder.bullet.setImageResource(R.drawable.ic_z_circle);
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


    /**
     * Stores and recycles views as they are scrolled off screen.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView bullet;
        TextView direction;
        TextView destination;
        TextView arrivalTime;

        ViewHolder(View itemView) {
            super(itemView);
            bullet = itemView.findViewById(R.id.bullet);
            direction = itemView.findViewById(R.id.direction);
            destination = itemView.findViewById(R.id.destination);
            arrivalTime = itemView.findViewById(R.id.arrival_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    /**
     * Get the train at clicked position
     *
     * @param position the position
     * @return the train at this position
     */
    private Train getTrain(int position) {
        return arrivals.get(position);
    }

    /**
     * Allows click events to be caught
     *
     * @param setItemClickListener the setItemClickListener
     */
    private void setClickListener(ItemClickListener setItemClickListener) {
        itemClickListener = setItemClickListener;
    }

    /**
     * Parent activity will implement this method to respond to click events
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
