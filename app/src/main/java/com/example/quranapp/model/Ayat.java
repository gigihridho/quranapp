package com.example.quranapp.model;

import com.google.gson.annotations.SerializedName;

public class Ayat {
    @SerializedName("number")
    private int numberAyat;

    @SerializedName("text")
    private String text;

    @SerializedName("numberInSurat")
    private int numberInSurat;

    @SerializedName("juz")
    private String juz;

    public Ayat(int numberAyat, String text, int numberInSurat, String juz) {
        this.numberAyat = numberAyat;
        this.text = text;
        this.numberInSurat = numberInSurat;
        this.juz = juz;
    }

    public int getNumberAyat() {
        return numberAyat;
    }

    public void setNumberAyat(int numberAyat) {
        this.numberAyat = numberAyat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberInSurat() {
        return numberInSurat;
    }

    public void setNumberInSurat(int numberInSurat) {
        this.numberInSurat = numberInSurat;
    }

    public String getJuz() {
        return juz;
    }

    public void setJuz(String juz) {
        this.juz = juz;
    }
}
