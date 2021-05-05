package com.example.moviesapiretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesapiretrofit.R;
import com.example.moviesapiretrofit.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private Context context;
    private int rowLayout;

    public MoviesAdapter(List<Movie> movies, Context context, int rowLayout) {
        this.movies = movies;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.tvMovieTitle.setText(movies.get(position).getTitle());
        holder.tvMovieSubTitle.setText(movies.get(position).getReleasedDate());
        holder.tvMovieDescription.setText(movies.get(position).getOverview());

        // toString did not worked here, "String.valueOf" is the best solution
        holder.tvMovieRating.setText(String.valueOf(movies.get(position).getVoteAverage()));

        Glide.with(context).load(movie.getBackDropPath()).into(holder.imImageView);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieTitle, tvMovieSubTitle, tvMovieDescription, tvMovieRating;
        LinearLayout moviesLayout;
        ImageView imImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            moviesLayout = itemView.findViewById(R.id.movies_layout);
            tvMovieTitle = itemView.findViewById(R.id.title);
            tvMovieSubTitle = itemView.findViewById(R.id.subtitle);
            tvMovieDescription = itemView.findViewById(R.id.description);
            tvMovieRating = itemView.findViewById(R.id.rating);
            imImageView = itemView.findViewById(R.id.movieImage);
        }
    }
}
