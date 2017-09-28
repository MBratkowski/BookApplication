package io.bratexsoft.booksapplication.di.module;

import android.app.Activity;
import android.content.Intent;

import dagger.Module;
import dagger.Provides;
import io.bratexsoft.booksapplication.di.scope.ActivityScope;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Intent provideIntent() {
        return activity.getIntent();
    }

}
