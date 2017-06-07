package com.x7.ssad.ticketsystem.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.x7.ssad.ticketsystem.Activities.CinemaDetail;
import com.x7.ssad.ticketsystem.Adapters.CinemaAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFragment extends Fragment {


    private SessionManager mSessionManager;
    private BackendStub backend;
    private List<Cinema> cinemaList;
    private  ListView cinemaListView;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_cinema, container, false);

        initView();
        initData();

        CinemaAdapter cinemaAdapter = new CinemaAdapter(cinemaList, getActivity());
        cinemaListView.setAdapter(cinemaAdapter);
        cinemaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CinemaDetail.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    private void initView() {
        cinemaListView = (ListView) rootView.findViewById(R.id.cinemaListView);
    }
    private void initData() {
        mSessionManager  = SessionManager.getInstance();
        backend = BackendStub.getInstance();
        cinemaList = backend.getCinemaList();
    }
}
