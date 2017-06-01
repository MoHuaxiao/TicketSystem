package com.x7.ssad.ticketsystem.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import com.x7.ssad.ticketsystem.Activities.MovieInfoActivity;
import com.x7.ssad.ticketsystem.Backend.BackendStub;
import com.x7.ssad.ticketsystem.Model.Movie;
import com.x7.ssad.ticketsystem.R;
import com.x7.ssad.ticketsystem.Session.SessionManager;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by WangYinghao on 5/26/17.
 */

public class HotOnAirMovieAdapter extends RecyclerView.Adapter<HotOnAirMovieAdapter.ViewHolder> {

    SessionManager SM = SessionManager.getInstance();

    Activity _a;
    Resources res;
    private BackendStub Backend;
    private List<Movie> movie_list;
    private LayoutInflater mInflater;

    SimpleDateFormat ft;

    public HotOnAirMovieAdapter(Activity activity, BackendStub backend) {
        super();
        Backend = backend;
        mInflater = LayoutInflater.from(activity);

        _a = activity;
        res = activity.getResources();
        movie_list = Backend.getHotOnAirMovies();
        ft = new SimpleDateFormat("yyyy.MM.dd");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_hot_on_air_movie, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        holder.poster = (ImageView) view.findViewById(R.id.hot_on_air_movie_poster_view);
        holder.movieName = (TextView) view.findViewById(R.id.hot_on_air_movie_name_view);
        holder.ratingText1 = (TextView) view.findViewById(R.id.hot_on_air_movie_rating_text1);
        holder.ratingText2 = (TextView) view.findViewById(R.id.hot_on_air_movie_rating_text2);
        holder.movieIntro = (TextView) view.findViewById(R.id.hot_on_air_movie_one_sentence_review_view);
        holder.showingTips = (TextView) view.findViewById(R.id.hot_on_air_movie_showing_cinema_view);
        holder.buyButton = (Button) view.findViewById(R.id.hot_on_air_wait_movie_buy_button);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {

        final Movie m = movie_list.get(i);

        Log.d("Adpater", m.name);

        Button buyNormal;
        Button buyWait;

        //Filling Item
        //TODO: Implement a Cinema Manager Stub
        int sc = 100, sn = 1000;
        holder.poster.setImageResource(m.imageid);
        holder.movieName.setText(m.name);
        holder.movieIntro.setText(m.movieIntro);

        //影片正在上演
        if (movie_list.get(i).onair) {
            holder.showingTips.setText(res.getString(R.string.showing_cinema, sc, sn));


            if (m.audience_rating != -1) {
                holder.ratingText1.setText("观众 ");
                holder.ratingText2.setText(String.format("%.1f", m.audience_rating));
                holder.ratingText1.setTextColor(res.getColor(R.color.textColor));
                holder.ratingText2.setTextColor(res.getColor(R.color.ratingColor));
            }
            else {
                holder.ratingText1.setText(res.getString(R.string.no_rating));
                holder.ratingText1.setTextColor(res.getColor(R.color.textColor));
                holder.ratingText2.setText("");
            }

            holder.buyButton.setText("购票");
            holder.buyButton.setTextColor(res.getColor(R.color.buyButtonColor));
            holder.buyButton.setBackground(res.getDrawable(R.drawable.button_movie_nor));

        }
        //影片还未上演
        else {

            holder.showingTips.setText(res.getString(R.string.premiere_date, ft.format(m.premiereDate), dateDescFromNow(m.premiereDate)));

            holder.ratingText1.setText(String.format("%d", m.nWantSee));
            holder.ratingText2.setText(" 想看");
            holder.ratingText1.setTextColor(res.getColor(R.color.ratingColor));
            holder.ratingText2.setTextColor(res.getColor(R.color.textColor));

            holder.buyButton.setText("预售");
            holder.buyButton.setTextColor(res.getColor(R.color.waitButtonColor));
            holder.buyButton.setBackground(res.getDrawable(R.drawable.button_movie_wait));
        }

        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Setting session
                SM.setMyMovieID(m.mid);
                SM.setOnAir(m.onair);
                //Go to movie info page.
                Intent i = new Intent(_a, MovieInfoActivity.class);
                _a.startActivity(i);
            }
        });
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
        public TextView movieIntro;
        public TextView showingTips;
        public Button buyButton;
        public ViewHolder(View itemView) {
            super(itemView);
        }

    }

    private String dateDescFromNow(Date d) {

        Date now = new Date();

        long diff = d.getTime() - now.getTime();

        int weeks = Double.valueOf(diff / 1000. / 3600. / 24. / 7.).intValue();
        int days = Double.valueOf(diff / 1000. / 3600. / 24.).intValue();

        if (weeks > 1) {
            return Integer.toString(weeks) + "周后";
        }
        else {
            return Integer.toString(days) + "天后";
        }

    }

}

