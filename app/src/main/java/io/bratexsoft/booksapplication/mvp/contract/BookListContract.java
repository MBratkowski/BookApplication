package io.bratexsoft.booksapplication.mvp.contract;

import io.bratexsoft.booksapplication.mvp.view.BaseView;

public interface BookListContract {

    interface Presenter {
        void itemClicked(int bookId);
    }

    interface View extends BaseView {
        void notifyAdapter();

        void openDetailsView(int bookId);
    }
}
