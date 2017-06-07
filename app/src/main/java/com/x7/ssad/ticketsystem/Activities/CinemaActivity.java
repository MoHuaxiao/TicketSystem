package com.x7.ssad.ticketsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.x7.ssad.ticketsystem.Adapters.CinemaAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class CinemaActivity extends AppCompatActivity {

    private SessionManager mSessionManager;
    private BackendStub backend;
    private List<Cinema> cinemaList;
    private  ListView cinemaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        initView();
        initData();

        System.out.println(mSessionManager.getMyMovieID());

//        Cinema c;
//        for (int i = 0; i < 10; i++) {
//            c = new Cinema("今日珠江国际影城", "番禺区小谷围贝岗二横路1好店 新天地店", 30);
//            cinemaList.add(c);
//        }

        CinemaAdapter cinemaAdapter = new CinemaAdapter(cinemaList, CinemaActivity.this);
        cinemaListView.setAdapter(cinemaAdapter);
        cinemaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSessionManager.setMyCinemaID(cinemaList.get(position).cid);
                Intent intent = new Intent(CinemaActivity.this, CinemaDetail.class);
                startActivity(intent);
            }
        });
    }

    void initData() {
        mSessionManager  = SessionManager.getInstance();
        backend = BackendStub.getInstance();
        cinemaList = new ArrayList<Cinema>();
        List<Long>  cinemaIds = backend.getCinemaIdsListByMovieId(mSessionManager.getMyMovieID());
        for (int i = 0; i < cinemaIds.size(); i++) {
            cinemaList.add(backend.getCinemaByID(cinemaIds.get(i)));
        }
    }
    void initView() {
        cinemaListView = (ListView) findViewById(R.id.cinemaListView);

    }
}
