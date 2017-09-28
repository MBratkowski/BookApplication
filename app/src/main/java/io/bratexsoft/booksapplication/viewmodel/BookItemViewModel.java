package io.bratexsoft.booksapplication.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class BookItemViewModel extends BaseObservable {

    private final int id;
    private final String name;
    private final String index;
    private final String imageUrl;

    public BookItemViewModel(int id, String name, String index, String imageUrl) {
        this.id = id;
        this.name = name;
        this.index = index;
        this.imageUrl = imageUrl;
    }

    @Bindable
    public int getId() {
        return id;
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
    public String getImageUrl() {
        return imageUrl;
    }
}
