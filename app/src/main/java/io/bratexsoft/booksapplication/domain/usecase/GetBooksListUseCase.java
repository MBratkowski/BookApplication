package io.bratexsoft.booksapplication.domain.usecase;

import java.util.List;

import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.domain.BaseUseCase;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;

public class GetBooksListUseCase implements BaseUseCase {

    private final BookEntityGateway entityGateway;
    private final DataCallback<List<Book>> callback;

    public GetBooksListUseCase(BookEntityGateway entityGateway, DataCallback<List<Book>> callback) {
        this.entityGateway = entityGateway;
        this.callback = callback;
    }

    @Override
    public void execute() {
        entityGateway.getBooksList(callback);
    }
}
