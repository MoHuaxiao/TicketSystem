package com.x7.ssad.ticketsystem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.x7.ssad.ticketsystem.Model.MovieComment;
import com.x7.ssad.ticketsystem.R;

import java.util.List;

/**
 * Created by John on 2017/5/28.
 */

public class MovieCommentAdapter extends RecyclerView.Adapter<MovieCommentAdapter.ViewHolder> {
    private List<MovieComment> movieCommentList;
    private LayoutInflater mInflater;

    public MovieCommentAdapter(Context context, List<MovieComment> _movieCommentList) {
        super();
        movieCommentList = _movieCommentList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieCommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_comment_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.headerView = (ImageView) view.findViewById(R.id.commentatorPhoto);
        holder.nameView = (TextView) view.findViewById(R.id.commentatorName);
        holder.contentView = (TextView) view.findViewById(R.id.movieCommentContent);
        holder.dateView = (TextView) view.findViewById(R.id.commentDate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieCommentAdapter.ViewHolder holder, int position) {
        holder.headerView.setImageBitmap(movieCommentList.get(position).headphoto);
        holder.nameView.setText(movieCommentList.get(position).mname);
        holder.contentView.setText(movieCommentList.get(position).mcontent);
        holder.dateView.setText(movieCommentList.get(position).mdate);
    }

    @Override
    public int getItemCount() {
        return movieCommentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView headerView;
        TextView nameView;
        TextView contentView;
        TextView dateView;
    }
}
