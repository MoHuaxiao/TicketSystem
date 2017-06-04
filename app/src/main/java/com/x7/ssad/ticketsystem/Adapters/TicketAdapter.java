package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Ticket;
import com.x7.ssad.ticketsystem.R;

import java.util.List;

/**
 * Created by Administrator on 2017/06/04.
 */

public class TicketAdapter extends BaseAdapter{
    private List<Ticket> list;
    private Context context;

    public TicketAdapter(List<Ticket> list, Context context) {
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
        TicketAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.ticket_item, null);
            viewHolder = new TicketAdapter.ViewHolder();
            viewHolder.startTime = (TextView) view.findViewById(R.id.startTime);
            viewHolder.endTime = (TextView) view.findViewById(R.id.endTime);
            viewHolder.type = (TextView) view.findViewById(R.id.type);
            viewHolder.price = (TextView) view.findViewById(R.id.price);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (TicketAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.startTime.setText(list.get(position).startTime);
        viewHolder.endTime.setText(list.get(position).endTime);
        viewHolder.type.setText(list.get(position).type);
        viewHolder.price.setText(list.get(position).price + "");
        return view;
    }

    private class ViewHolder {
        public TextView startTime;
        public TextView endTime;
        public TextView type;
        public TextView price;
    }
}
