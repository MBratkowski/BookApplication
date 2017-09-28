package io.bratexsoft.booksapplication.app;

import android.app.Application;

public class BooksApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BooksApplicationInjector.INSTANCE.initApplicationComponent(this);
    }
}
