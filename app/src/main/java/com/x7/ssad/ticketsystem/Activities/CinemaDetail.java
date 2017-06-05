package com.x7.ssad.ticketsystem.Activities;

import android.content.Intent;
import android.database.CursorJoiner;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.x7.ssad.ticketsystem.Adapters.MovieShotBlockAdapter;
import com.x7.ssad.ticketsystem.Adapters.TicketAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.Ticket;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class CinemaDetail extends AppCompatActivity {

    private SessionManager SM;
    private BackendStub backend;

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

        RecyclerView movieShootRecyclerView = (RecyclerView)findViewById(R.id.movieShot);
        backend = BackendStub.getInstance();
        SM = SessionManager.getInstance();
        // 获取数据
//        Movie CurrentMovie = backend.getMovieByID(SM.getMyMovieID());
        int movieshotIdList[] = {R.mipmap.movie_shot, R.mipmap.movie_shot,
                R.mipmap.movie_shot, R.mipmap.movie_shot, R.mipmap.movie_shot};

        MovieShotBlockAdapter movieShotBlockAdapter = new MovieShotBlockAdapter(getApplicationContext(), movieshotIdList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CinemaDetail.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieShootRecyclerView.setLayoutManager(linearLayoutManager);
        movieShootRecyclerView.setAdapter(movieShotBlockAdapter);
    }
}
