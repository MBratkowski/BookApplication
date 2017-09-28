package io.bratexsoft.booksapplication.mvp.presenter;

import io.bratexsoft.booksapplication.mvp.view.BaseView;

public class BasePresenter<ViewType extends BaseView> {

    private ViewType view;

    public final void onTakeView(ViewType view) {
        this.view = view;
        onTakenView(view);
    }

    public final void onDropView() {
        view = null;
    }

    public void onTakenView(ViewType view) {
        //Implement by children
    }

    public ViewType getView() {
        if (view != null) {
            return view;
        } else {
            throw new IllegalArgumentException("View is null");
        }
    }
}
