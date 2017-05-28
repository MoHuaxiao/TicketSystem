package com.x7.ssad.ticketsystem.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.x7.ssad.ticketsystem.Adapters.HotOnAirMovieAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        BackendStub backend = BackendStub.getInstance();

        RecyclerView HotOnAirMovieList = (RecyclerView) rootView.findViewById(R.id.hot_on_air_movie_recycview);

        LinearLayoutManager mLLM = new LinearLayoutManager(getActivity().getApplicationContext());
        mLLM.setOrientation(LinearLayoutManager.VERTICAL);
        HotOnAirMovieList.setLayoutManager(mLLM);

        Log.d("Activity", Integer.toString(backend.getHotOnAirMovies().size()));

        HotOnAirMovieList.setAdapter(new HotOnAirMovieAdapter(getActivity().getApplicationContext(), backend));
        return rootView;
    }
}
