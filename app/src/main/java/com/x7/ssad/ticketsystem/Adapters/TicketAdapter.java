package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Activities.MainActivity;
import com.x7.ssad.ticketsystem.Activities.SelectSeatActivity;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Ticket;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.util.List;

/**
 * Created by Administrator on 2017/06/04.
 */

public class TicketAdapter extends BaseAdapter{
    private List<Ticket> list;
    private Context context;
    private SessionManager mSessionManager;

    public TicketAdapter(List<Ticket> list, Context context) {
        this.list = list;
        this.context = context;
        mSessionManager = SessionManager.getInstance();
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
            viewHolder.order_btn = (Button) view.findViewById(R.id.order_btn);
            viewHolder.order_btn.setTag(position);
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
        viewHolder.order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                传入数据
                mSessionManager.setStartTime(list.get((Integer)v.getTag()).startTime);
                mSessionManager.setEndTime(list.get((Integer)v.getTag()).endTime);
                Intent intent = new Intent(context, SelectSeatActivity.class);
                context.startActivity(intent);

            }
        });
        return view;
    }

    private class ViewHolder {
        public TextView startTime;
        public TextView endTime;
        public TextView type;
        public TextView price;
        public Button order_btn;
    }
}
