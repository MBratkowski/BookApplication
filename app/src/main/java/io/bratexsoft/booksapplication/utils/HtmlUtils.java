package io.bratexsoft.booksapplication.utils;

import android.text.Html;

public final class HtmlUtils {

    public static String parseHtml(String value) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(value).toString();
        }
    }
}
