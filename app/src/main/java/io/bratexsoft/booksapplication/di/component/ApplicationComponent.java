package io.bratexsoft.booksapplication.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.bratexsoft.booksapplication.app.BooksApplication;
import io.bratexsoft.booksapplication.di.module.ApplicationModule;
import io.bratexsoft.booksapplication.di.module.RemoteDataModule;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;

@Singleton
@Component(modules = {ApplicationModule.class, RemoteDataModule.class})
public interface ApplicationComponent {

    UseCaseFactory getUseCaseFactory();

    void inject(BooksApplication application);
}
