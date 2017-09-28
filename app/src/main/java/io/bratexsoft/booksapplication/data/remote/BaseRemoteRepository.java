package io.bratexsoft.booksapplication.data.remote;

import io.bratexsoft.booksapplication.data.BooksService;

public class BaseRemoteRepository {

    protected final BooksService apiService;
    protected final ResponseRemoteHandler handler;

    public BaseRemoteRepository(BooksService apiService, ResponseRemoteHandler handler) {
        this.apiService = apiService;
        this.handler = handler;
    }

}
