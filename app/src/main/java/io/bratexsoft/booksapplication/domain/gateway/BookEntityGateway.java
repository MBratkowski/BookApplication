package io.bratexsoft.booksapplication.domain.gateway;

import java.util.List;

import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.data.data.BookLike;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;

public interface BookEntityGateway extends Gateway {

    void getBooksList(DataCallback<List<Book>> callback);

    void getBookDetails(DataCallback<BookDetails> callback, int id);

    void likeBook(DataCallback<Void> callback, BookLike like);

    void unlikeBook(DataCallback<Void> callback, BookLike like);
}
