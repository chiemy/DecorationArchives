package com.chiemy.demo.decorationarchives.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;


/**
 * Created by mingjun on 16/8/17.
 */
public class ImageLoader {

    public static void load(int resId, ImageView view) {
        load(Uri.parse(getUriString(resId, view.getContext())), view);
    }

    @NonNull
    private static String getUriString(int resId, Context context) {
        StringBuilder builder = new StringBuilder("android.resource://");
        builder.append(context.getPackageName())
                .append("/drawable/")
                .append(context.getResources().getResourceName(resId));
        return builder.toString();
    }


    public static void load(Uri source, ImageView view) {
        setScaleType(view, Glide.with(view.getContext()).load(source).asBitmap())
        .into(view);
    }

    private static BitmapRequestBuilder setScaleType(ImageView view, BitmapRequestBuilder builder) {
        return setScaleType(view.getScaleType(), builder);
    }

    private static BitmapRequestBuilder setScaleType(ImageView.ScaleType scaleType, BitmapRequestBuilder builder) {
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            builder.fitCenter();
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            builder.centerCrop();
        }
        return builder;
    }

    public static void loadSquare(Uri source, ImageView view, int size, int placeHolderResourceId) {
        loadResize(source, view, size, size, placeHolderResourceId);
    }

    public static void loadResize(Uri source, ImageView view, int width, int height, int placeHolderResourceId) {
        setScaleType(view, Glide.with(view.getContext()).load(source).asBitmap())
                .override(width, height)
                .placeholder(placeHolderResourceId)
                .into(view);
    }

}
