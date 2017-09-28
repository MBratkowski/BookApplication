package io.bratexsoft.booksapplication.data;

import java.util.List;

import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.data.data.BookLike;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BooksService {

    @GET("/comicbooks")
    Call<List<Book>> getBooksList();

    @GET("/comicbooks/{id}")
    Call<BookDetails> getBookDetails(@Path("id") int bookId);

    @POST("/comicbooks/like/")
    Call<Void> likeBook(@Body BookLike bookLike);

    @POST("/comicbooks/unlike/")
    Call<Void> unlikeBook(@Body BookLike bookLike);

}
