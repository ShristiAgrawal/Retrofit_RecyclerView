package com.example.retrofit_rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private CustomAdapter adapter;
private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Services service=Client.getinstance().create(Services.class);
        Call<RetroPhoto> call=service.getPopularMovies("dbea4e917d02e56372d6083c682aeab6","en-US", 2);
        call.enqueue(new Callback<RetroPhoto>() {
            @Override
            public void onResponse(Call<RetroPhoto> call, Response<RetroPhoto> response) {
                generatelist(response.body());
            }

            @Override
            public void onFailure(Call<RetroPhoto> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generatelist(RetroPhoto body) {
        rv=findViewById(R.id.rv);
        adapter=new CustomAdapter(this,body.getMovies());
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);


    }
}
