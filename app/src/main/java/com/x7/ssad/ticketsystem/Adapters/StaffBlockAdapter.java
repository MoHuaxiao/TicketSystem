package com.x7.ssad.ticketsystem.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Model.StaffInfo;
import com.x7.ssad.ticketsystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class StaffBlockAdapter extends RecyclerView.Adapter<StaffBlockAdapter.ViewHolder> {
    private List<StaffInfo> staffInfoList;
    private LayoutInflater mInflater;

    public StaffBlockAdapter(Context context, List<StaffInfo> _staffInfoList) {
        super();
        staffInfoList = _staffInfoList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.staff_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.staffPhotoView = (ImageView) view.findViewById(R.id.staffPhoto);
        holder.staffNameView = (TextView) view.findViewById(R.id.staffName);
        holder.staffDutyView = (TextView) view.findViewById(R.id.staffDuty);
        return holder;
    }

    @Override
    public void onBindViewHolder(StaffBlockAdapter.ViewHolder holder, int position) {
        holder.staffPhotoView.setImageBitmap(staffInfoList.get(position).sphoto);
        holder.staffNameView.setText(staffInfoList.get(position).sname);
        holder.staffDutyView.setText(staffInfoList.get(position).sduty);
    }

    @Override
    public int getItemCount() {
        return staffInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView staffPhotoView;
        TextView staffNameView;
        TextView staffDutyView;
    }
}
