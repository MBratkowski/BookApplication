package io.bratexsoft.booksapplication.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.bratexsoft.booksapplication.app.BooksApplicationInjector;
import io.bratexsoft.booksapplication.di.component.ActivityComponent;
import io.bratexsoft.booksapplication.di.component.ApplicationComponent;
import io.bratexsoft.booksapplication.di.component.DaggerActivityComponent;
import io.bratexsoft.booksapplication.di.module.ActivityModule;
import io.bratexsoft.booksapplication.mvp.presenter.BasePresenter;
import io.bratexsoft.booksapplication.mvp.view.BaseView;

public abstract class BaseActivity<B extends ViewDataBinding, V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {

    @Inject
    P presenter;

    B binding;

    private ActivityComponent activityComponent;

    @LayoutRes
    abstract int getLayoutRest();

    abstract void performFieldInjection(ActivityComponent activityComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutRest());
        performFieldInjection(getActivityComponent());
        presenter.onTakeView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDropView();
    }

    private ApplicationComponent getApplicationComponent() {
        return BooksApplicationInjector.INSTANCE.getApplicationComponent();
    }

    private ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return activityComponent;
    }
}
