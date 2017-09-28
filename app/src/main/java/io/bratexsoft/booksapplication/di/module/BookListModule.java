package io.bratexsoft.booksapplication.di.module;

import dagger.Module;
import dagger.Provides;
import io.bratexsoft.booksapplication.adapter.BooksListAdapter;
import io.bratexsoft.booksapplication.di.scope.PerView;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;
import io.bratexsoft.booksapplication.mvp.presenter.BookListPresenter;

@Module
public class BookListModule {

    @PerView
    @Provides
    public BookListPresenter providePresenter(UseCaseFactory useCaseFactory) {
        return new BookListPresenter(useCaseFactory);
    }

    @PerView
    @Provides
    public BooksListAdapter provideAdapter(BookListPresenter presenter) {
        return new BooksListAdapter(presenter);
    }
}
