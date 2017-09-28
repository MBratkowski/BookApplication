package io.bratexsoft.booksapplication.mvp.contract;

import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.mvp.view.BaseView;

public interface BookDetailsContract {

    interface Presenter {
        void likeBook(int bookId);
    }

    interface View extends BaseView {
        void updateLikeCount(boolean isLiked);

        void notifyView(BookDetails result);
    }
}
