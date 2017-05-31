package com.x7.ssad.ticketsystem.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Adapters.MovieCommentAdapter;
import com.x7.ssad.ticketsystem.Adapters.MovieShootBlockAdapter;
import com.x7.ssad.ticketsystem.Adapters.StaffBlockAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.MovieComment;
import com.x7.ssad.ticketsystem.Model.StaffInfo;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Mo Haoran on 2017/5/26.
 */

public class MovieInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView movieImageView;
    private TextView movieNameView;
    private TextView scoreView;
    private TextView airingTimeView;
    private TextView introView;

    private List<StaffInfo> staffInfoList = new ArrayList<>();    //the infomation list of staffs
    private List<Bitmap> movieShootList = new ArrayList<>();
    private List<MovieComment> movieCommentList = new ArrayList<>();

    private RecyclerView mainStaffRecyclerView;
    private StaffBlockAdapter myStaffBlockAdapter;
    private RecyclerView movieShootRecyclerView;
    private MovieShootBlockAdapter myMovieShootBlockAdapter;
    private RecyclerView movieCommentRecyclerView;
    private MovieCommentAdapter myMovieCommentAdapter;

    private SessionManager SM;
    private BackendStub backend;

    //UI
    Button ticketBookingBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        backend = BackendStub.getInstance();
        SM = SessionManager.getInstance();

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");

        ImageView movieImageView = (ImageView) findViewById(R.id.movieImg);
        TextView movieNameView = (TextView) findViewById(R.id.movieTitle);
        TextView scoreView = (TextView) findViewById(R.id.Score);
        TextView airingTimeView = (TextView) findViewById(R.id.movieOnTime);
        TextView introView = (TextView) findViewById(R.id.movieIntroText);

        Movie CurrentMovie = backend.getMovieByID(SM.getMyMovieID());

        movieImageView.setImageResource(CurrentMovie.imageid);
        movieNameView.setText(CurrentMovie.name);
        scoreView.setText(String.format("%.1f", CurrentMovie.audience_rating));
        airingTimeView.setText(smf.format(CurrentMovie.premiereDate) + " 大陆上映");
        introView.setText(CurrentMovie.one_sentence);

        //主创Staff部分
        mainStaffRecyclerView = (RecyclerView)findViewById(R.id.mainStaff);

        StaffInfo mStaffInfo = new StaffInfo(BitmapFactory.decodeResource(getResources(), R.mipmap.johnny_depp),
                "Johnny Depp", "Captain Jack");
        for (int i = 0; i < 7; i++)
            staffInfoList.add(mStaffInfo);

        //设置Staff部分的adapter 以及RecyclerView
        myStaffBlockAdapter = new StaffBlockAdapter(getApplicationContext(), staffInfoList);
        LinearLayoutManager llm = new LinearLayoutManager(MovieInfoActivity.this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainStaffRecyclerView.setLayoutManager(llm);
        mainStaffRecyclerView.setAdapter(myStaffBlockAdapter);

        //电影剪影部分
        movieShootRecyclerView = (RecyclerView)findViewById(R.id.movieShoot);

        Bitmap testBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.movie_shoot);
        for (int i = 0; i < 6; i++)
            movieShootList.add(testBmp);

        //设置MovieShoot部分的adapter 以及RecyclerView
        myMovieShootBlockAdapter = new MovieShootBlockAdapter(getApplicationContext(), movieShootList);
        LinearLayoutManager llm2 = new LinearLayoutManager(MovieInfoActivity.this);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieShootRecyclerView.setLayoutManager(llm2);
        movieShootRecyclerView.setAdapter(myMovieShootBlockAdapter);

        //影评comment部分
        movieCommentRecyclerView = (RecyclerView)findViewById(R.id.movieComment);

        MovieComment mMovieComment = new MovieComment(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher),
                "评论员1",
                "饰 杰克船长333333aaaaaaaaaaa啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊凄凄切切群群群群群群群群群群群群群",
                "05-06");
        for (int i = 0; i < 4; i++)
            movieCommentList.add(mMovieComment);

        //设置comment部分的adapter 以及RecyclerView
        myMovieCommentAdapter = new MovieCommentAdapter(getApplicationContext(), movieCommentList);
        LinearLayoutManager llm3 = new LinearLayoutManager(MovieInfoActivity.this);
        llm3.setOrientation(LinearLayoutManager.VERTICAL);
        movieCommentRecyclerView.setLayoutManager(llm3);
        movieCommentRecyclerView.setAdapter(myMovieCommentAdapter);

        ticketBookingBtn = (Button)findViewById(R.id.ticketBookingBtn);
        ticketBookingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ticketBookingBtn:
                //跳转逻辑
//                Intent intent = new Intent(MovieInfoActivity.this, LoginActivity.class);
//                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
