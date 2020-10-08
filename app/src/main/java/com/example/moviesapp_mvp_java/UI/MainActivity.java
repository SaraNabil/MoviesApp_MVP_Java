package com.example.moviesapp_mvp_java.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moviesapp_mvp_java.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , MovieView {

    TextView movieNameTv ;
    Button getMovieBtn;
    MoviePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieNameTv = findViewById(R.id.textView);
        getMovieBtn = findViewById(R.id.button);

        getMovieBtn.setOnClickListener(this);
        presenter = new MoviePresenter(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            presenter.getMovie();
        }
    }

    @Override
    public void onGetMovieName(String movieName) {
        movieNameTv.setText(movieName);
    }
}