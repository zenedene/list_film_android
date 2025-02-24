package com.example.listfilm;
// StudentAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.StudentViewHolder> {
    private ArrayList<Film> filmList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Film film);
    }

    // Constructor to initialize the adapter with data
    public FilmAdapter(ArrayList<Film> filmList, OnItemClickListener listener) {
        this.filmList = filmList;
        this.listener = listener;
    }


    // Membuat ViewHolder baru
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout student_item.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        return new StudentViewHolder(view);
    }

    // Mengikat data ke ViewHolder
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Film currentFilm = filmList.get(position);
        holder.tvJudul.setText(currentFilm.getJudul());
        holder.tvGenre.setText(currentFilm.getGenre());
        holder.ivPoster.setImageResource(currentFilm.getImageResId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentFilm);
            }
        });
    }

    // Mengembalikan jumlah item
    @Override
    public int getItemCount() {
        return filmList.size();
    }

    // ViewHolder untuk menyimpan referensi view tiap item
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvJudul, tvGenre;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvJudul = itemView.findViewById(R.id.tvJudul);
        }
    }
}
