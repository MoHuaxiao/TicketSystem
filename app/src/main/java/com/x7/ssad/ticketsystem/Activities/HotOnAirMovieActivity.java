package com.x7.ssad.ticketsystem.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.x7.ssad.ticketsystem.Adapters.HotOnAirMovieAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.R;

import java.util.List;

public class HotOnAirMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_on_air_movie);

        BackendStub backend = BackendStub.getInstance();

        RecyclerView HotOnAirMovieList = (RecyclerView) findViewById(R.id.hot_on_air_movie_recycview);

        LinearLayoutManager mLLM = new LinearLayoutManager(getApplicationContext());
        mLLM.setOrientation(LinearLayoutManager.VERTICAL);
        HotOnAirMovieList.setLayoutManager(mLLM);

        Log.d("Activity", Integer.toString(backend.getHotOnAirMovies().size()));

        HotOnAirMovieList.setAdapter(new HotOnAirMovieAdapter(getApplicationContext(), backend));

    }
}
