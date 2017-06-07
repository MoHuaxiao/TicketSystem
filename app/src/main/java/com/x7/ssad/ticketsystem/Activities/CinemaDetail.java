package com.x7.ssad.ticketsystem.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Adapters.MovieImageListAdapter;
import com.x7.ssad.ticketsystem.Adapters.TicketAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.Ticket;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;
import com.x7.ssad.ticketsystem.Utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CinemaDetail extends AppCompatActivity {

    private SessionManager mSessionManager;
    private BackendStub backend;
    private Cinema mCinema;
    private Movie mMovie;
    private ListView ticketListView;
    private List<Ticket> ticketList = new ArrayList<Ticket>();;

    private int[] movieshotIdList;
//    private int[] movieshotIdList = {R.mipmap.movie_shot, R.mipmap.movie_shot,
//            R.mipmap.movie_shot, R.mipmap.movie_shot, R.mipmap.movie_shot};

    private long[] ShowingMovie;

    private TextView cName;
    private TextView cPosition;
    private TextView cScore;
    private TextView movieNmae;
    private TextView movieLengthAndTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_detail);

        initData();
        initView();
        updateView();

        final TicketAdapter ticketAdapter = new TicketAdapter(ticketList, this);
        ticketListView.setAdapter(ticketAdapter);

        RecyclerView movieShootRecyclerView = (RecyclerView)findViewById(R.id.movieShot);
        // 获取数据
//        Movie CurrentMovie = backend.getMovieByID(SM.getMyMovieID());
        final MovieImageListAdapter movieImageListAdapter = new MovieImageListAdapter(getApplicationContext(), movieshotIdList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CinemaDetail.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieShootRecyclerView.setLayoutManager(linearLayoutManager);
        movieImageListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mSessionManager.setMyMovieID( backend.getMovieByID((int)mCinema.ShowingMovie[position]).mid);
                initData();
                updateView();
                System.out.println(ticketList.size());
                ticketAdapter.notifyDataSetChanged();
            }
        });
        movieShootRecyclerView.setAdapter(movieImageListAdapter);
    }

    private void initView() {
        ticketListView = (ListView) findViewById(R.id.ticket_list);
        cPosition = (TextView) findViewById(R.id.cPosition);
        cScore = (TextView) findViewById(R.id.cScore);
        cName = (TextView) findViewById(R.id.cName);
        movieNmae = (TextView) findViewById(R.id.movieName);
        movieLengthAndTag = (TextView) findViewById(R.id.movieLenghAndTag);
    }

    public void updateView() {
        cName.setText(mCinema.cName);
        cPosition.setText(mCinema.cPosition);
        cScore.setText(mCinema.cScore + "");
        movieNmae.setText(mMovie.name);
        movieLengthAndTag.setText(mMovie.movieLength + "|动画|山新");
    }


    public void initData() {

        mSessionManager  = SessionManager.getInstance();
        backend = BackendStub.getInstance();
        mCinema = backend.getCinemaByID(mSessionManager.getMyCinemaID());
        mMovie = backend.getMovieByID(mSessionManager.getMyMovieID());

        ShowingMovie = mCinema.ShowingMovie;
        movieshotIdList = new int[mCinema.ShowingMovie.length];
        for (int i = 0; i < mCinema.ShowingMovie.length; i++) {
            movieshotIdList[i] = backend.getMovieByID((int)mCinema.ShowingMovie[i]).imageid;
        }

//        ticketList = new ArrayList<Ticket>();
        ticketList.clear();
        for (int i = 0; i < mCinema.cTicketList.size(); i++) {
            if (mCinema.cTicketList.get(i).mid == mMovie.mid) {
                ticketList.add(mCinema.cTicketList.get(i));
            }
        }
    }
}
