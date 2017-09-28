package io.bratexsoft.booksapplication.di.component;

import dagger.Subcomponent;
import io.bratexsoft.booksapplication.activity.BookListActivity;
import io.bratexsoft.booksapplication.di.module.BookListModule;
import io.bratexsoft.booksapplication.di.scope.PerView;

@PerView
@Subcomponent(modules = BookListModule.class)
public interface BookListComponent {
    void inject(BookListActivity activty);
}
