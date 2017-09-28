package io.bratexsoft.booksapplication.data.data;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("full_title")
    private String fullTitle;
    @SerializedName("main_image")
    private String mainImage;

    private int id;
    private int index;

    public int getId() {
        return id;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public int getIndex() {
        return index;
    }
}
