package io.bratexsoft.booksapplication.domain;

import java.util.List;

import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.data.data.BookLike;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;
import io.bratexsoft.booksapplication.domain.usecase.GetBookDetailsUseCase;
import io.bratexsoft.booksapplication.domain.usecase.GetBooksListUseCase;
import io.bratexsoft.booksapplication.domain.usecase.LikeBookUseCase;
import io.bratexsoft.booksapplication.domain.usecase.UnlikeBookUseCase;

public final class UseCaseFactory {

    private final BookEntityGateway bookEntityGateway;

    public UseCaseFactory(BookEntityGateway bookEntityGateway) {
        this.bookEntityGateway = bookEntityGateway;
    }

    public GetBooksListUseCase getBooksList(DataCallback<List<Book>> callback) {
        return new GetBooksListUseCase(bookEntityGateway, callback);
    }

    public GetBookDetailsUseCase getBookDetails(DataCallback<BookDetails> callback, int bookId) {
        return new GetBookDetailsUseCase(bookEntityGateway, callback, bookId);
    }

    public LikeBookUseCase likeBook(DataCallback<Void> callback, BookLike like) {
        return new LikeBookUseCase(bookEntityGateway, callback, like);
    }

    public UnlikeBookUseCase unlikeBook(DataCallback<Void> callback, BookLike like) {
        return new UnlikeBookUseCase(bookEntityGateway, callback, like);
    }
}
