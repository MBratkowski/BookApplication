package io.bratexsoft.booksapplication.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import javax.inject.Inject;

import io.bratexsoft.booksapplication.R;
import io.bratexsoft.booksapplication.adapter.BooksListAdapter;
import io.bratexsoft.booksapplication.databinding.BookListActivtyBinding;
import io.bratexsoft.booksapplication.di.component.ActivityComponent;
import io.bratexsoft.booksapplication.di.module.BookListModule;
import io.bratexsoft.booksapplication.mvp.contract.BookListContract;
import io.bratexsoft.booksapplication.mvp.presenter.BookListPresenter;

public class BookListActivity extends BaseActivity<BookListActivtyBinding, BookListContract.View, BookListPresenter>
        implements BookListContract.View {

    @Inject
    BooksListAdapter adapter;

    @Override
    int getLayoutRest() {
        return R.layout.book_list_activty;
    }

    @Override
    void performFieldInjection(ActivityComponent activityComponent) {
        activityComponent.plusModule(new BookListModule())
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openDetailsView(int bookId) {
        BookDetailsActivity.startActivity(this, bookId);
    }
}
