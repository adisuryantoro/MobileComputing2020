package id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.mobilecomputing.mobilecomputing2020.R;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.adapter.MoviesPopularAdapter;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.model.MoviesPopularResponse;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.model.Result;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.network.APIClient;
import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.network.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesPopularActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private final static String API_KEY = "b77b6755ae8f447262dfc0528394955f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_popular);

        recyclerView= findViewById(R.id.rv_movies_popular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<MoviesPopularResponse> call = apiInterface.getMoviesPopular(API_KEY);
        call.enqueue(new Callback<MoviesPopularResponse>() {
            @Override
            public void onResponse(Call<MoviesPopularResponse> call, Response<MoviesPopularResponse> response) {
                List<Result> results = response.body().getResults();
                recyclerView.setAdapter(new MoviesPopularAdapter(results, R.layout.item_movies_popular, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesPopularResponse> call, Throwable t) {
//                Toast.makeText(this, "Get Data Movies Failed" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
        APICallMoviesPopular();
    }

    private void APICallMoviesPopular() {

    }
}