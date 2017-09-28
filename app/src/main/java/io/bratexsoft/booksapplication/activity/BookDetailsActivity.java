package io.bratexsoft.booksapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.bratexsoft.booksapplication.R;
import io.bratexsoft.booksapplication.data.Config;
import io.bratexsoft.booksapplication.data.data.BookDetails;
import io.bratexsoft.booksapplication.databinding.BookDetailsActivityBinding;
import io.bratexsoft.booksapplication.di.component.ActivityComponent;
import io.bratexsoft.booksapplication.di.module.BookDetailsModule;
import io.bratexsoft.booksapplication.mvp.contract.BookDetailsContract;
import io.bratexsoft.booksapplication.mvp.presenter.BookDetailsPresenter;
import io.bratexsoft.booksapplication.utils.HtmlUtils;
import io.bratexsoft.booksapplication.viewmodel.BookDetailsViewModel;

public class BookDetailsActivity extends BaseActivity<BookDetailsActivityBinding, BookDetailsContract.View, BookDetailsPresenter>
        implements BookDetailsContract.View {

    public static final String BOOK_KEY = "book_key";
    public static final int DEFAULT_INTENT_VALUE = 0;

    private BookDetailsViewModel viewModel = new BookDetailsViewModel();

    public static void startActivity(Context context, int id) {
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtra(BOOK_KEY, id);
        context.startActivity(intent);
    }

    @Override
    int getLayoutRest() {
        return R.layout.book_details_activity;
    }

    @Override
    void performFieldInjection(ActivityComponent activityComponent) {
        activityComponent.plusModule(new BookDetailsModule()).inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setPresenter(presenter);
        binding.setViewModel(viewModel);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateLikeCount(boolean isLiked) {
        if (isLiked) {
            viewModel.setLikes(String.valueOf(Integer.valueOf(viewModel.getLikes()) + 1));
            binding.likeButton.setText(R.string.book_details_button_unlike);
        } else {
            binding.likeButton.setText(R.string.book_details_button_like);
            viewModel.setLikes(String.valueOf(Integer.valueOf(viewModel.getLikes()) - 1));
        }
    }

    @Override
    public void notifyView(BookDetails result) {
        viewModel.updateAllFieldsViewModel(result.getId(), Config.BASE_URL + "/" + result.getMainImage(), result.getFullTitle(),
                String.valueOf(result.getIndex()), String.valueOf(result.getLikes()), HtmlUtils.parseHtml(result.getDescription()));

    }
}
