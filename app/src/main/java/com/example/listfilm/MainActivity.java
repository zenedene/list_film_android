package com.example.listfilm;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;
    private ArrayList<Film> filmList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        filmList = new ArrayList<>();
        filmList.add(new Film("Boboiboy the movie", "Animation", R.drawable.boboiboy_poster, "08-08-2019", "BoBoiBoy and his friends have been attacked by a villain named Retak'ka who is the original user of BoBoiBoy's powers. He seeks to take back his powers from him to become the most powerful person and dominate the galaxy.", generateRandomRating()));
        filmList.add(new Film("Mencuri Raden Saleh", "Action, Thriller", R.drawable.mencuri_raden, "25-09-2022", "To save his father, a master forger sets out to steal an invaluable painting with the help of a motley crew of specialists.", generateRandomRating()));
// La La Land
        filmList.add(new Film(
                "La La Land",
                "Musical/Romance",
                R.drawable.lalaland,
                "12-12-2016",
                "A jazz pianist falls for an aspiring actress in Los Angeles as they pursue their dreams.",
                generateRandomRating()
        ));

// 500 Days of Summer
        filmList.add(new Film(
                "500 Days of Summer",
                "Romantic Comedy/Drama",
                R.drawable.daysofsummer,
                "07-07-2009",
                "An unconventional take on modern love, chronicling the rise and fall of a relationship.",
                generateRandomRating()
        ));

// Scary Movie series
        filmList.add(new Film(
                "Scary Movie",
                "Comedy/Horror",
                R.drawable.skerimufi1,
                "07-08-2000",
                "A hilarious parody of various horror films that blends scares with laughter.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Scary Movie 2",
                "Comedy/Horror",
                R.drawable.skerimufi2,
                "07-12-2001",
                "A sequel delivering absurd humor in the eerie setting of a haunted mansion.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Scary Movie 3",
                "Comedy/Horror",
                R.drawable.skerimufi3,
                "01-05-2003",
                "An even crazier parody tale with unexpected twists and turns.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Scary Movie 4",
                "Comedy/Horror",
                R.drawable.skeriii,
                "04-07-2006",
                "A parody film that hilariously mocks various horror and sci-fi movies with its unique style.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Scary Movie V",
                "Comedy/Horror",
                R.drawable.skerimufi5,
                "04-04-2013",
                "The fifth installment offering unexpected humor through parodies of modern horror films.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Habibie & Ainun",
                "Biography/Romance",
                R.drawable.habibie_ainun,
                "25-12-2012",
                "An everlasting love story that narrates the journey of life and devotion between Habibie and Ainun.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "Bolehkah Sekali Saja...",
                "Drama",
                R.drawable.bolehkah_sekali_saja_ku_menangis,
                "15-03-2016",
                "An emotional journey that unveils the vulnerability of the heart and the strength to endure sorrow.",
                generateRandomRating()
        ));

        filmList.add(new Film(
                "5cm",
                "Adventure/Drama",
                R.drawable.five_cm,
                "30-11-2012",
                "A tale of friendship and adventure that inspires us to keep dreaming and conquer challenges.",
                generateRandomRating()
        ));



        filmAdapter = new FilmAdapter(filmList, Film ->{
            Intent intent = new Intent(MainActivity.this, DetailActivity.class );
            intent.putExtra("judul", Film.getJudul());
            intent.putExtra("genre", Film.getGenre());
            intent.putExtra("poster", Film.getImageResId());
            intent.putExtra("rilis", Film.getRilis());
            intent.putExtra("sinopsis", Film.getSinopsis());
            intent.putExtra("rating", Film.getRating());
            startActivity(intent);
        });
        recyclerView.setAdapter(filmAdapter);
    }

        // Fungsi untuk menghasilkan angka acak antara 1 dan 5
        public int generateRandomRating() {
            Random random = new Random();
            // nextInt(5) menghasilkan nilai antara 0-4, sehingga ditambahkan 1 agar rentangnya menjadi 1-5
            return random.nextInt(5) + 1;
    }
}