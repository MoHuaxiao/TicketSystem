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
import com.x7.ssad.ticketsystem.Model.Cinema;
import com.x7.ssad.ticketsystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_cinema, container, false);
        ListView cinemaListView = (ListView) rootView.findViewById(R.id.cinemaListView);

        List<Cinema> cinemaList = new ArrayList<Cinema>();
        Cinema c;
        for (int i = 0; i < 10; i++) {
            c = new Cinema("今日珠江国际影城", "番禺区小谷围贝岗二横路1好店 新天地店", 30);
            cinemaList.add(c);
        }
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
}
