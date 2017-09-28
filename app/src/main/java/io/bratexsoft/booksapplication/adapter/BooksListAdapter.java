package io.bratexsoft.booksapplication.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.bratexsoft.booksapplication.R;
import io.bratexsoft.booksapplication.databinding.BookItemBinding;
import io.bratexsoft.booksapplication.mvp.presenter.BookListPresenter;

public class BooksListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final BookListPresenter presenter;

    public BooksListAdapter(BookListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<>(DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.book_item,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        BookItemBinding itemBinding = (BookItemBinding) holder.getBinding();
        itemBinding.setViewModel(presenter.getViewModelItem(position));
        itemBinding.setPresenter(presenter);
        itemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return presenter.getSize();
    }
}
