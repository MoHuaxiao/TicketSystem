package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.R;

import java.util.List;

/**
 * Created by Administrator on 2017/06/03.
 */


public class CinemaAdapter extends BaseAdapter {

    private List<Cinema> list;
    private Context context;

    public CinemaAdapter(List<Cinema> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.cinema_item, null);
            viewHolder = new ViewHolder();
            viewHolder.cName = (TextView) view.findViewById(R.id.cName);
            viewHolder.cPosition = (TextView) view.findViewById(R.id.cPosition);
            viewHolder.cLowestPrice = (TextView) view.findViewById(R.id.cLowestPrice);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.cName.setText(list.get(position).cName);
        viewHolder.cPosition.setText(list.get(position).cPosition);
        viewHolder.cLowestPrice.setText(list.get(position).cLowestPrice + "");
        return view;
    }

    private class ViewHolder {
        public TextView cName;
        public TextView cPosition;
        public TextView cLowestPrice;
    }
}
