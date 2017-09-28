package io.bratexsoft.booksapplication.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.bratexsoft.booksapplication.data.BooksService;
import io.bratexsoft.booksapplication.data.remote.BookRemoteRepository;
import io.bratexsoft.booksapplication.data.remote.ResponseRemoteHandler;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }


    @Provides
    public BookEntityGateway provideBookEntityGateway(BooksService service, ResponseRemoteHandler handler) {
        return new BookRemoteRepository(service, handler);
    }

    @Provides
    public UseCaseFactory provideUseCaseFactory(BookEntityGateway bookEntityGateway) {
        return new UseCaseFactory(bookEntityGateway);
    }
}
