package io.bratexsoft.booksapplication.data.remote;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.bratexsoft.booksapplication.domain.callback.DataCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ResponseRemoteHandler {

    private static final boolean IS_REMOTE = true;

    @Inject
    public ResponseRemoteHandler() {
        //For Dagger 2
    }

    public <T> Callback<T> setRetrofitCallback(final DataCallback dataCallback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                preprocessRespone(response, dataCallback);
            }

            @Override
            public void onFailure(Call<T> call, Throwable throwable) {
                preprocessFailure(throwable, dataCallback);
            }
        };
    }

    private void preprocessRespone(Response response, DataCallback callback) {
        if (response.isSuccessful()) {
            callback.onSuccess(response.body(), IS_REMOTE);
        } else {
            String errorMessage;
            if (response.errorBody() != null) {
                try {
                    errorMessage = response.errorBody().string();
                } catch (IOException e) {
                    errorMessage = response.message();
                }
            } else {
                errorMessage = response.message();
            }
            callback.onFailure(response.code(), errorMessage, IS_REMOTE);
        }
    }

    private void preprocessFailure(Throwable throwable, DataCallback callback) {
        if (throwable instanceof IOException) { //don't report the errors from null auth token or a network error
            return;
        }
        callback.onFailure(ErrorTypeHandling.getErrorCode(throwable), throwable.getMessage(), IS_REMOTE);
    }
}
