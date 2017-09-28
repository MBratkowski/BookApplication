package io.bratexsoft.booksapplication.domain.usecase;

import io.bratexsoft.booksapplication.data.data.BookLike;
import io.bratexsoft.booksapplication.domain.BaseUseCase;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;

public class LikeBookUseCase implements BaseUseCase {

    private final BookEntityGateway entityGateway;
    private final DataCallback<Void> callback;
    private final BookLike bookLike;

    public LikeBookUseCase(BookEntityGateway entityGateway, DataCallback<Void> callback, BookLike bookLike) {
        this.entityGateway = entityGateway;
        this.callback = callback;
        this.bookLike = bookLike;
    }

    @Override
    public void execute() {
        entityGateway.likeBook(callback, bookLike);
    }
}
