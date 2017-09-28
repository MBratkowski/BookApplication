package io.bratexsoft.booksapplication.di.component;

import dagger.Subcomponent;
import io.bratexsoft.booksapplication.activity.BookDetailsActivity;
import io.bratexsoft.booksapplication.di.module.BookDetailsModule;
import io.bratexsoft.booksapplication.di.scope.PerView;

@PerView
@Subcomponent(modules = BookDetailsModule.class)
public interface BookDetailsComponent {
    void inject(BookDetailsActivity activity);
}
