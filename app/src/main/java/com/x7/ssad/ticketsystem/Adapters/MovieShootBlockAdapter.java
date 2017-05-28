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

public class MovieShootBlockAdapter extends RecyclerView.Adapter<MovieShootBlockAdapter.ViewHolder> {
    private List<Bitmap> movieShootList;
    private LayoutInflater mInflater;

    public MovieShootBlockAdapter(Context context, List<Bitmap> _movieShootList) {
        super();
        movieShootList = _movieShootList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieShootBlockAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_shoot_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.movieShootView = (ImageView) view.findViewById(R.id.movieShoot);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieShootBlockAdapter.ViewHolder holder, int position) {
        holder.movieShootView.setImageBitmap(movieShootList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieShootList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView movieShootView;
    }
}
