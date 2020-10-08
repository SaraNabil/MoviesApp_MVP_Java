package com.example.moviesapp_mvp_java.UI;

import android.util.Log;

import com.example.moviesapp_mvp_java.Pojo.MovieModel;
import com.example.moviesapp_mvp_java.Service.ApiClient;
import com.example.moviesapp_mvp_java.Service.ApiInterFace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter {
    MovieView view;
    String movieName = "";

    public MoviePresenter(MovieView view) {
        this.view = view;
    }

    //get data from database
    public void getMovie() {
        ApiInterFace service = ApiClient.getClient();
        Call<MovieModel> call = service.getListOfMovies("movie", "day", "5954db931e9993ddb65982259ca72648");
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.body() != null) {
                    MovieModel movieModelList = response.body();
                    movieName = movieModelList.getResults().get(0).getTitle();
                    view.onGetMovieName(movieName);
                    Log.d("MyProject",   "");
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                movieName = t.getMessage() + "";
                Log.d("MyProject", t.getMessage() + "");
            }
        });
    }

//    //get movie name from MainActivity
//    public void getMovieName() {
//        view.onGetMovieName(getMovie());
//    }
}
