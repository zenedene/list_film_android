package com.example.listfilm;

public class Film {
    private String judul, genre, rilis, sinopsis;

    private int imageResId, rating; // Resource ID untuk gambar


    public Film(String judul, String genre, int imageResId, String rilis, String sinopsis, int rating) {
        this.judul = judul;
        this.genre = genre;
        this.imageResId = imageResId;
        this.rilis = rilis;
        this.sinopsis = sinopsis;
        this.rating = rating;
    }

    public String getJudul(){
        return judul;
    }

    public String getGenre(){
        return genre;
    }

    public String getRilis(){
        return rilis;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public int getImageResId(){
        return imageResId;
    }

    public int getRating(){
        return rating;
    }
}
