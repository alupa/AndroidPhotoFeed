package edu.galileo.android.photofeed.libs.base;

import android.widget.ImageView;

/**
 * Created by Alvaro on 16-06-2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
