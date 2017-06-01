package com.x7.ssad.ticketsystem.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Adapters.MovieCommentAdapter;
import com.x7.ssad.ticketsystem.Adapters.MovieShotBlockAdapter;
import com.x7.ssad.ticketsystem.Adapters.StaffBlockAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.BoxOffice;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.MovieComment;
import com.x7.ssad.ticketsystem.Model.StaffInfo;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mo Haoran on 2017/5/26.
 */

public class MovieInfoActivity extends AppCompatActivity implements View.OnClickListener {
    // ui
    private ImageView movieImageView;
    private TextView movieNameView, movieNameEngView ,scoreView, scorePeopleSumView,
                movieTypeView, movieDestView, movieLength, airingTimeView;
    private TextView introView;
    private TextView boxOfficeRankView, boxOfficeWeekView, boxOfficeTotalView;

    private RecyclerView mainStaffRecyclerView;
    private StaffBlockAdapter myStaffBlockAdapter;
    private RecyclerView movieShotRecyclerView;
    private MovieShotBlockAdapter myMovieShotBlockAdapter;
    private RecyclerView movieCommentRecyclerView;
    private MovieCommentAdapter myMovieCommentAdapter;

    private Button ticketBookingBtn;

    //singletons
    private SessionManager SM;
    private BackendStub backend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        backend = BackendStub.getInstance();
        SM = SessionManager.getInstance();

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");

        initUIComponents();

        Movie CurrentMovie = backend.getMovieByID(SM.getMyMovieID());

        //电影基本信息部分
        movieImageView.setImageResource(CurrentMovie.imageid);
        movieNameView.setText(CurrentMovie.name);
        movieNameEngView.setText(CurrentMovie.nameEng);
        scoreView.setText(String.format("%.1f", CurrentMovie.audience_rating));
        scorePeopleSumView.setText("(" + CurrentMovie.audience_num + "人评)");
        movieTypeView.setText(CurrentMovie.movieType);
        movieDestView.setText(CurrentMovie.movieSourceDest);
        movieLength.setText(CurrentMovie.movieLength + "分钟");
        airingTimeView.setText(smf.format(CurrentMovie.premiereDate) + " 大陆上映");

        introView.setText(CurrentMovie.movieIntro);

        //主创Staff部分: 设置Staff部分的adapter 以及RecyclerView
        List<StaffInfo> staffInfoList = CurrentMovie.staffList;
        myStaffBlockAdapter = new StaffBlockAdapter(getApplicationContext(), staffInfoList);
        LinearLayoutManager llm = new LinearLayoutManager(MovieInfoActivity.this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainStaffRecyclerView.setLayoutManager(llm);
        mainStaffRecyclerView.setAdapter(myStaffBlockAdapter);

        //电影剪影部分: 设置MovieShot部分的adapter 以及RecyclerView
        int[] movieShotList = CurrentMovie.movieshotIdList;
        myMovieShotBlockAdapter = new MovieShotBlockAdapter(getApplicationContext(), movieShotList);
        LinearLayoutManager llm2 = new LinearLayoutManager(MovieInfoActivity.this);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        movieShotRecyclerView.setLayoutManager(llm2);
        movieShotRecyclerView.setAdapter(myMovieShotBlockAdapter);

        //票房部分
        BoxOffice boxOffice = CurrentMovie.boxOffice;
        boxOfficeRankView.setText(boxOffice.boxOfficeRank + "");
        boxOfficeWeekView.setText(boxOffice.boxOfficeFirstWeek + "");
        boxOfficeTotalView.setText(boxOffice.boxOfficeTotal + "");

        //影评comment部分: 设置comment部分的adapter 以及RecyclerView
        List<MovieComment> movieCommentList = CurrentMovie.commentList;
        myMovieCommentAdapter = new MovieCommentAdapter(getApplicationContext(), movieCommentList);
        LinearLayoutManager llm3 = new LinearLayoutManager(MovieInfoActivity.this);
        llm3.setOrientation(LinearLayoutManager.VERTICAL);
        movieCommentRecyclerView.setLayoutManager(llm3);
        movieCommentRecyclerView.setAdapter(myMovieCommentAdapter);

        //订票按钮部分
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

    private void initUIComponents() {
        movieImageView = (ImageView) findViewById(R.id.movieImg);
        movieNameView = (TextView) findViewById(R.id.movieTitle);
        movieNameEngView = (TextView) findViewById(R.id.movieTitleEng);
        scoreView = (TextView) findViewById(R.id.Score);
        scorePeopleSumView = (TextView) findViewById(R.id.ScorePeopleSum);
        movieTypeView = (TextView) findViewById(R.id.movieType);
        movieDestView = (TextView) findViewById(R.id.movieSourceDest);
        movieLength = (TextView) findViewById(R.id.movieLength);
        airingTimeView = (TextView) findViewById(R.id.movieOnTime);
        introView = (TextView) findViewById(R.id.movieIntroText);

        mainStaffRecyclerView = (RecyclerView)findViewById(R.id.mainStaff);
        movieShotRecyclerView = (RecyclerView)findViewById(R.id.movieShot);

        boxOfficeRankView = (TextView) findViewById(R.id.boxOfficeRank);
        boxOfficeWeekView = (TextView) findViewById(R.id.boxOfficeWeek);
        boxOfficeTotalView = (TextView) findViewById(R.id.boxOfficeTotal);

        movieCommentRecyclerView = (RecyclerView)findViewById(R.id.movieComment);

        ticketBookingBtn = (Button)findViewById(R.id.ticketBookingBtn);
    }

}
