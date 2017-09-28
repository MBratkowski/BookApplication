package io.bratexsoft.booksapplication.di.component;

import dagger.Component;
import io.bratexsoft.booksapplication.di.module.ActivityModule;
import io.bratexsoft.booksapplication.di.module.BookDetailsModule;
import io.bratexsoft.booksapplication.di.module.BookListModule;
import io.bratexsoft.booksapplication.di.scope.ActivityScope;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    BookDetailsComponent plusModule(BookDetailsModule module);

    BookListComponent plusModule(BookListModule module);
}
