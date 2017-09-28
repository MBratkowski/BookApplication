package io.bratexsoft.booksapplication.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import io.bratexsoft.booksapplication.BR;

public class BookDetailsViewModel extends BaseObservable {

    private int id;
    private String imageUrl;
    private String name;
    private String index;
    private String likes;
    private String description;

    public BookDetailsViewModel() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getIndex() {
        return index;
    }

    @Bindable
    public String getLikes() {
        return likes;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public void updateAllFieldsViewModel(int id, String imageUrl, String name, String index, String likes, String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.index = index;
        this.likes = likes;
        this.description = description;
        this.id = id;

        notifyPropertyChanged(BR.imageUrl);
        notifyPropertyChanged(BR.name);
        notifyPropertyChanged(BR.likes);
        notifyPropertyChanged(BR.index);
        notifyPropertyChanged(BR.description);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setIndex(String index) {
        this.index = index;
        notifyPropertyChanged(BR.index);
    }

    public void setLikes(String likes) {
        this.likes = likes;
        notifyPropertyChanged(BR.likes);
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
}
