package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.os.Debug;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

public class HotOnAirMovieAdapter extends RecyclerView.Adapter<HotOnAirMovieAdapter.ViewHolder> {

    Context c;
    LayoutInflater li;
    Resources res;
    private BackendStub Backend;
    private List<Movie> movie_list;
    private LayoutInflater mInflater;

    public HotOnAirMovieAdapter(Context context, BackendStub backend) {
        super();
        c = context;
        Backend = backend;
        mInflater = LayoutInflater.from(context);

        li = LayoutInflater.from(context);
        res = context.getResources();
        movie_list = Backend.getHotOnAirMovies();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_hot_on_air_movie, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        holder.poster = (ImageView) view.findViewById(R.id.hot_on_air_movie_poster_view);
        holder.movieName = (TextView) view.findViewById(R.id.hot_on_air_movie_name_view);
        holder.ratingText1 = (TextView) view.findViewById(R.id.hot_on_air_movie_rating_text1);
        holder.ratingText2 = (TextView) view.findViewById(R.id.hot_on_air_movie_rating_text2);
        holder.oneSentence = (TextView) view.findViewById(R.id.hot_on_air_movie_one_sentence_review_view);
        holder.showingCinema = (TextView) view.findViewById(R.id.hot_on_air_movie_showing_cinema_view);
        holder.buyButtonLayout = (LinearLayout) view.findViewById(R.id.hot_on_air_movie_button_stub);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {

        Movie m = movie_list.get(i);

        Log.d("Adpater", m.name);

        Button buyNormal;
        Button buyWait;

        //Filling Item
        //TODO: Implement a Cinema Manager Stub
        int sc = 100, sn = 1000;
        holder.poster.setImageResource(m.imageid);
        holder.movieName.setText(m.name);
        holder.oneSentence.setText(m.one_sentence);
        holder.showingCinema.setText(res.getString(R.string.showing_cinema, sc, sn));
        if (movie_list.get(i).onair) {
            holder.ratingText1.setText("观众 ");
            holder.ratingText2.setText(String.format("%.2f", m.audience_rating));
            holder.ratingText2.setTextColor(res.getColor(R.color.ratingColor));

            buyNormal = (Button) li.inflate(R.layout.layout_button_movie_nor, holder.buyButtonLayout, false);
            holder.buyButtonLayout.addView(buyNormal);
        }
        else {
            holder.ratingText1.setText(String.format("%d", m.nWantSee));
            holder.ratingText2.setText(" 想看");
            holder.ratingText1.setTextColor(c.getResources().getColor(R.color.ratingColor));

            buyWait = (Button) li.inflate(R.layout.layout_button_movie_wait, holder.buyButtonLayout, false);
            holder.buyButtonLayout.addView(buyWait);
        }

    }

    @Override
    public int getItemCount() {
        return Backend.getHotOnAirMovies().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView poster;
        public TextView movieName;
        public TextView ratingText1;
        public TextView ratingText2;
        public TextView oneSentence;
        public TextView showingCinema;
        public LinearLayout buyButtonLayout;
        public ViewHolder(View itemView) {
            super(itemView);
        }

    }

}
