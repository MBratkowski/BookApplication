package io.bratexsoft.booksapplication.mvp.presenter;

import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.data.data.BookLike;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.mvp.contract.BookDetailsContract;

public class BookDetailsPresenter extends BasePresenter<BookDetailsContract.View> implements BookDetailsContract.Presenter,
        DataCallback<BookDetails> {

    private final UseCaseFactory useCaseFactory;
    private final int bookId;

    private boolean isLiked = false;

    public BookDetailsPresenter(UseCaseFactory useCaseFactory, int bookId) {
        this.useCaseFactory = useCaseFactory;
        this.bookId = bookId;
    }

    @Override
    public void onTakenView(BookDetailsContract.View view) {
        super.onTakenView(view);
        useCaseFactory.getBookDetails(this, bookId).execute();
    }

    @Override
    public void onSuccess(BookDetails result, boolean isRemote) {
        getView().notifyView(result);
    }

    @Override
    public void onFailure(int errorCode, String message, boolean isRemote) {
        getView().showError(message);
    }

    @Override
    public void likeBook(int bookId) {
        BookLike bookLike = new BookLike(bookId);
        if (!isLiked) {
            useCaseFactory.likeBook(new DataCallback<Void>() {
                @Override
                public void onSuccess(Void result, boolean isRemote) {

                }

                @Override
                public void onFailure(int errorCode, String message, boolean isRemote) {
                    getView().showError(message);
                }
            }, bookLike);
            isLiked = true;
            getView().updateLikeCount(isLiked);
        } else {
            useCaseFactory.unlikeBook(new DataCallback<Void>() {
                @Override
                public void onSuccess(Void result, boolean isRemote) {

                }

                @Override
                public void onFailure(int errorCode, String message, boolean isRemote) {
                    getView().showError(message);
                }
            }, bookLike);
            isLiked = false;
            getView().updateLikeCount(isLiked);
        }
    }
}
