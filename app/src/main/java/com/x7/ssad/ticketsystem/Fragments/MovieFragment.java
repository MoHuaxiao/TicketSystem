package com.x7.ssad.ticketsystem.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.x7.ssad.ticketsystem.Activities.MainActivity;
import com.x7.ssad.ticketsystem.Adapters.HotOnAirMovieAdapter;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.Model.User;
import com.x7.ssad.ticketsystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private List<Movie> movies;
    HotOnAirMovieAdapter movieAdapter;

    private GetMovietask getMovietask;

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

        movies = new ArrayList<>();
        movieAdapter = new HotOnAirMovieAdapter(getActivity(), movies);
        HotOnAirMovieList.setAdapter(movieAdapter);

        getMovietask = new GetMovietask(getActivity());
        getMovietask.execute((Void) null);

        return rootView;
    }

    /**
     * Asynchronous task to retrieve movie list.
     */
    public class GetMovietask extends AsyncTask<Void, Void, List> {

        Activity _a;
        BackendStub mBackend;


        GetMovietask(Activity a) {
            _a = a;
            mBackend = BackendStub.getInstance();
        }

        @Override
        protected List doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            List<Movie> movieRetrieved;
            try {
                // Simulate network access.
                movieRetrieved = mBackend.getHotOnAirMovies();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return movieRetrieved;

        }

        @Override
        protected void onPostExecute(final List movieRetrieved) {
            if (movieRetrieved != null) {
                movies.addAll(movieRetrieved);
                movieAdapter.notifyDataSetChanged();
            }

        }

        @Override
        protected void onCancelled() {
        }
    }

}





