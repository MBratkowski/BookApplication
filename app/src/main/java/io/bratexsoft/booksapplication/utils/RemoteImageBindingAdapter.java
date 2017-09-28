package io.bratexsoft.booksapplication.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

public final class RemoteImageBindingAdapter {

    private RemoteImageBindingAdapter() {
    }

    @BindingAdapter(value = {"imageUrl", "imagePlaceholder"}, requireAll = false)
    public static void setRemoteImage(final ImageView imageView, String imageUrl,
                                      Drawable imagePlaceholder) {

        if (TextUtils.isEmpty(imageUrl)) {
            imageUrl = "/";
        }

        DrawableTypeRequest<String> load = Glide.with(imageView.getContext()).load(imageUrl);
        if (imagePlaceholder != null) {
            load.error(imagePlaceholder)
                    .placeholder(imagePlaceholder);
        }
        load.into(imageView);
    }

}
