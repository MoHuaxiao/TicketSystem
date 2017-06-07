package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.x7.ssad.ticketsystem.R;

/**
 * Created by Administrator on 2017/06/07.
 */

public class MovieImageListAdapter extends RecyclerView.Adapter<MovieImageListAdapter.ViewHolder> {

    private int[] movieshotIdList;
    private LayoutInflater mInflater;
    private Context context;

    public MovieImageListAdapter(Context context, int[] _movieshotIdList) {
        super();
        movieshotIdList = _movieshotIdList;
        mInflater = LayoutInflater.from(context);
        context = context;
    }

    @Override
    public MovieImageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_shot_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.movieShotView = (ImageView) view.findViewById(R.id.movieShot);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieImageListAdapter.ViewHolder holder, int position) {
        holder.movieShotView.setImageResource(movieshotIdList[position]);
        holder.movieShotView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("bbbbbbbbbbbbb");
            }
        });
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




