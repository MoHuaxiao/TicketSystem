package com.x7.ssad.ticketsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.x7.ssad.ticketsystem.Adapters.TicketAdapter;
import com.x7.ssad.ticketsystem.Model.Ticket;
import com.x7.ssad.ticketsystem.R;

import java.util.ArrayList;
import java.util.List;

public class CinemaDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_detail);
        ListView ticketListView = (ListView) findViewById(R.id.ticket_list);
        List<Ticket> ticketList = new ArrayList<Ticket>();
        Ticket t;
        for (int i = 0; i < 10; i++) {
            t = new Ticket("17:05", "20:30", "原版3D", 48);
            ticketList.add(t);
        }
        TicketAdapter ticketAdapter = new TicketAdapter(ticketList, this);
        ticketListView.setAdapter(ticketAdapter);
    }
}
