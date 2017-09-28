package io.bratexsoft.booksapplication.app;

import android.app.Application;

import io.bratexsoft.booksapplication.di.component.ApplicationComponent;
import io.bratexsoft.booksapplication.di.component.DaggerApplicationComponent;
import io.bratexsoft.booksapplication.di.module.ApplicationModule;
import io.bratexsoft.booksapplication.di.module.RemoteDataModule;

public enum BooksApplicationInjector {
    INSTANCE;

    private ApplicationComponent applicationComponent;

    void initApplicationComponent(Application application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .remoteDataModule(new RemoteDataModule())
                .build();
    }


    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            throw new NullPointerException("applicationComponent is null");
        }
        return applicationComponent;
    }
}
