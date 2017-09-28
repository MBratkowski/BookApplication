package io.bratexsoft.booksapplication.data.remote;

import java.util.List;

import javax.inject.Inject;

import io.bratexsoft.booksapplication.data.BooksService;
import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.data.data.BookLike;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.domain.gateway.BookEntityGateway;

public class BookRemoteRepository extends BaseRemoteRepository implements BookEntityGateway {

    @Inject
    public BookRemoteRepository(BooksService booksService, ResponseRemoteHandler handler) {
        super(booksService, handler);
    }

    @Override
    public void getBooksList(DataCallback<List<Book>> callback) {
        apiService.getBooksList().enqueue(handler.<List<Book>>setRetrofitCallback(callback));
    }

    @Override
    public void getBookDetails(DataCallback<BookDetails> callback, int id) {
        apiService.getBookDetails(id).enqueue(handler.<BookDetails>setRetrofitCallback(callback));
    }

    @Override
    public void likeBook(DataCallback<Void> callback, BookLike like) {
        apiService.likeBook(like).enqueue(handler.<Void>setRetrofitCallback(callback));
    }

    @Override
    public void unlikeBook(DataCallback<Void> callback, BookLike like) {
        apiService.unlikeBook(like).enqueue(handler.<Void>setRetrofitCallback(callback));
    }
}
