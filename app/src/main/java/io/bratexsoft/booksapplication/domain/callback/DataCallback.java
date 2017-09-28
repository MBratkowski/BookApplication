package io.bratexsoft.booksapplication.domain.callback;

public interface DataCallback<ResultType> {

    void onSuccess(ResultType result, boolean isRemote);

    void onFailure(int errorCode, String message, boolean isRemote);
}
