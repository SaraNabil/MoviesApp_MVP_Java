package com.example.moviesapp_mvp_java.Service;

import com.example.moviesapp_mvp_java.Pojo.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterFace {

    @GET("trending/{media_type}/{time_window}")
    Call<MovieModel> getListOfMovies(@Path("media_type") String mediaType,
                                          @Path("time_window") String timeWindow,
                                          @Query("api_key") String apiKey);

}
