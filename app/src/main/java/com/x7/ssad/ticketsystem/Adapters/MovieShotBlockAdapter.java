package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.x7.ssad.ticketsystem.R;

import java.util.List;

/**
 * Created by Mo Haoran on 2017/5/28.
 */

public class MovieShotBlockAdapter extends RecyclerView.Adapter<MovieShotBlockAdapter.ViewHolder> {
    private int[] movieshotIdList;
    private LayoutInflater mInflater;

    public MovieShotBlockAdapter(Context context, int[] _movieshotIdList) {
        super();
        movieshotIdList = _movieshotIdList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieShotBlockAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_shot_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.movieShotView = (ImageView) view.findViewById(R.id.movieShot);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieShotBlockAdapter.ViewHolder holder, int position) {
        holder.movieShotView.setImageResource(movieshotIdList[position]);
    }

    @Override
    public int getItemCount() {
        return movieshotIdList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView movieShotView;
    }
}
