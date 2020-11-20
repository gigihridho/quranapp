package com.example.quranapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("surahs")
    private List surahs;
    private List ayats;
    private Edition edition;

    public Data(List surahs, Edition edition) {
        this.surahs = surahs;
        this.edition = edition;
    }

    public Data(List surahs, List ayats, Edition edition) {
        this.surahs = surahs;
        this.ayats = ayats;
        this.edition = edition;
    }

    public List getSurahs() {
        return surahs;
    }

    public void setSurahs(List surahs) {
        this.surahs = surahs;
    }

    public List getAyats() {
        return ayats;
    }

    public void setAyats(List ayats) {
        this.ayats = ayats;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}
