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
import android.widget.TextView;

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

    private SessionManager mSessionManager;
    private BackendStub backend;
    private Cinema mCinema;
    private Movie mMovie;
    private ListView ticketListView;
    private List<Ticket> ticketList;
    private int[] movieshotIdList = {R.mipmap.movie_shot, R.mipmap.movie_shot,
            R.mipmap.movie_shot, R.mipmap.movie_shot, R.mipmap.movie_shot};

    private TextView cName;
    private TextView cPosition;
    private TextView cScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_detail);

        initData();
        initView();

        cName.setText(mCinema.cName);
        cPosition.setText(mCinema.cPosition);
        cScore.setText(mCinema.cScore + "");


        TicketAdapter ticketAdapter = new TicketAdapter(ticketList, this);
        ticketListView.setAdapter(ticketAdapter);

        RecyclerView movieShootRecyclerView = (RecyclerView)findViewById(R.id.movieShot);
        // 获取数据
//        Movie CurrentMovie = backend.getMovieByID(SM.getMyMovieID());

        MovieShotBlockAdapter movieShotBlockAdapter = new MovieShotBlockAdapter(getApplicationContext(), movieshotIdList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CinemaDetail.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieShootRecyclerView.setLayoutManager(linearLayoutManager);
        movieShootRecyclerView.setAdapter(movieShotBlockAdapter);
    }

    private void initView() {
        ticketListView = (ListView) findViewById(R.id.ticket_list);
        cPosition = (TextView) findViewById(R.id.cPosition);
        cScore = (TextView) findViewById(R.id.cScore);
        cName = (TextView) findViewById(R.id.cName);

    }
    private void initData() {

        mSessionManager  = SessionManager.getInstance();
        backend = BackendStub.getInstance();
        mCinema = backend.getCinemaByID(mSessionManager.getMyCinemaID());
        mMovie = backend.getMovieByID(mSessionManager.getMyMovieID());

        System.out.println(mMovie.mid);
        System.out.println(mCinema.cTicketList.size());
        System.out.println(mCinema.cTicketList.toString());


        ticketList = new ArrayList<Ticket>();
        for (int i = 0; i < mCinema.cTicketList.size(); i++) {
            if (mCinema.cTicketList.get(i).mid == mMovie.mid) {
                ticketList.add(mCinema.cTicketList.get(i));
            }
        }
    }
}
