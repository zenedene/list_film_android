package com.example.listfilm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    Button btnBack;
    TextView tvJudul, tvGenre, tvRilis, tvSinopsis, tvRating;
    ImageView ivPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        String judul = getIntent().getStringExtra("judul");
        String genre = getIntent().getStringExtra("genre");
        String rilis = getIntent().getStringExtra("rilis");
        String sinopsis = getIntent().getStringExtra("sinopsis");
        int poster = getIntent().getIntExtra("poster", 0);
        int rating = getIntent().getIntExtra("rating", 0);

        btnBack = findViewById(R.id.btnBack);
        tvJudul = findViewById(R.id.tvJudul);
        tvGenre = findViewById(R.id.tvGenre);
        tvRilis = findViewById(R.id.tvRilis);
        ivPoster = findViewById(R.id.ivPoster);
        tvSinopsis = findViewById(R.id.tvSinopsis);
        tvRating = findViewById(R.id.tvRating);

        tvJudul.setText(judul);
        tvGenre.setText(genre);
        tvSinopsis.setText(sinopsis);
        tvRilis.setText(rilis);
        ivPoster.setImageResource(poster);
        tvRating.setText(rating+"/5");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}