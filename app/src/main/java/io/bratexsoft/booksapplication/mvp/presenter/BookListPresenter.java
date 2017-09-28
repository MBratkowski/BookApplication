package io.bratexsoft.booksapplication.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import io.bratexsoft.booksapplication.data.Config;
import io.bratexsoft.booksapplication.data.data.Book;
import io.bratexsoft.booksapplication.domain.UseCaseFactory;
import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import io.bratexsoft.booksapplication.mvp.contract.BookListContract;
import io.bratexsoft.booksapplication.viewmodel.BookItemViewModel;

public class BookListPresenter extends BasePresenter<BookListContract.View> implements BookListContract.Presenter,
        DataCallback<List<Book>> {

    private final UseCaseFactory useCaseFactory;
    private List<BookItemViewModel> viewModelList = new ArrayList<>();

    public BookListPresenter(UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    @Override
    public void onTakenView(BookListContract.View view) {
        super.onTakenView(view);
        useCaseFactory.getBooksList(this).execute();
    }

    @Override
    public void onSuccess(List<Book> result, boolean isRemote) {
        for (Book book : result) {
            String url = Config.BASE_URL + "/" + book.getMainImage();
            viewModelList.add(new BookItemViewModel(book.getId(), book.getFullTitle(),
                    String.valueOf(book.getIndex()),
                    url));
        }
        getView().notifyAdapter();
    }

    @Override
    public void onFailure(int errorCode, String message, boolean isRemote) {
        getView().showError(message);
    }

    public BookItemViewModel getViewModelItem(int position) {
        return viewModelList.get(position);
    }

    public int getSize() {
        return viewModelList.size();
    }

    @Override
    public void itemClicked(int bookId) {
        getView().openDetailsView(bookId);
    }
}
