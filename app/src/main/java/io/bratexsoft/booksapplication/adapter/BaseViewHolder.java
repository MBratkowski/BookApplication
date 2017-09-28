package io.bratexsoft.booksapplication.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BaseViewHolder<Binding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final Binding binding;

    public BaseViewHolder(Binding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public Binding getBinding() {
        return binding;
    }
}
