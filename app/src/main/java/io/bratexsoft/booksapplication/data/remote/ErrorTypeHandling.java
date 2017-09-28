package io.bratexsoft.booksapplication.data.remote;

import java.io.IOException;

public final class ErrorTypeHandling {

    private static final int ERROR_GENERIC = -1;
    private static final int ERROR_NETWORK = -2;

    private ErrorTypeHandling() {
    }

    public static int getErrorCode(Throwable throwable) {
        return throwable instanceof IOException ? ERROR_NETWORK : ERROR_GENERIC;
    }

    public static boolean isNetworkError(int errorCode) {
        return errorCode == ERROR_NETWORK;
    }
}