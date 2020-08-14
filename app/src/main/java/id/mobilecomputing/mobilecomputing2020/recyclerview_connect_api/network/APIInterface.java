package id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.network;

import id.mobilecomputing.mobilecomputing2020.recyclerview_connect_api.model.MoviesPopularResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("popular")
    Call<MoviesPopularResponse> getMoviesPopular(@Query("api_key") String api_key);

}
