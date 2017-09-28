package io.bratexsoft.booksapplication.domain.usecase;

import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.domain.BaseUseCase;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;

public class GetBookDetailsUseCase implements BaseUseCase {

    private final BookEntityGateway entityGateway;
    private final DataCallback<BookDetails> callback;
    private final int bookId;

    public GetBookDetailsUseCase(BookEntityGateway entityGateway, DataCallback<BookDetails> callback, int bookId) {
        this.entityGateway = entityGateway;
        this.callback = callback;
        this.bookId = bookId;
    }

    @Override
    public void execute() {
        entityGateway.getBookDetails(callback, bookId);
    }
}
