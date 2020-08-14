package id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.adapter;

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

import java.util.List;

import id.mobilecomputing.mobilecomputing2020.R;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.model.Result;

public class MoviesPopularAdapter extends RecyclerView.Adapter<MoviesPopularAdapter.MoviesPopularViewHolder> {

    private List<Result> results;
    private int columnItem;
    private Context context;

    public MoviesPopularAdapter(List<Result> results, int columnItem, Context context) {
        this.results = results;
        this.columnItem = columnItem;
        this.context = context;
    }


    @NonNull
    @Override
    public MoviesPopularAdapter.MoviesPopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(columnItem, parent, false);
        return new MoviesPopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesPopularAdapter.MoviesPopularViewHolder holder, int position) {
        Glide.with(context).load("http://image.tmdb.org/t/p/w185/" + results
                .get(position)
                .getPosterPath())
                .override(200, 200)
                .into(holder.ivPosterPath);
        holder.tvTitle.setText(results.get(position).getTitle());
        holder.tvOverview.setText(results.get(position).getOverview());
        holder.tvReleaseDate.setText(results.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class MoviesPopularViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvTitle, tvOverview, tvReleaseDate;
        ImageView ivPosterPath;

        public MoviesPopularViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_movies_popular);
            tvTitle = itemView.findViewById(R.id.title);
            tvOverview = itemView.findViewById(R.id.subtitle);
            tvReleaseDate = itemView.findViewById(R.id.description);
            ivPosterPath = itemView.findViewById(R.id.movies_poster_path);
        }
    }
}
