package io.bratexsoft.booksapplication.di.module;

import android.content.Intent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.bratexsoft.booksapplication.activity.BookDetailsActivity;
import io.bratexsoft.booksapplication.di.scope.PerView;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;
import io.bratexsoft.booksapplication.mvp.presenter.BookDetailsPresenter;

@Module
public class BookDetailsModule {

    @Provides
    @PerView
    @Named("bookId")
    public int provideBookId(Intent intent) {
        return intent.getIntExtra(BookDetailsActivity.BOOK_KEY, BookDetailsActivity.DEFAULT_INTENT_VALUE);
    }

    @PerView
    @Provides
    public BookDetailsPresenter providePresenter(UseCaseFactory useCaseFactory, @Named("bookId") int bookId) {
        return new BookDetailsPresenter(useCaseFactory, bookId);
    }
}
