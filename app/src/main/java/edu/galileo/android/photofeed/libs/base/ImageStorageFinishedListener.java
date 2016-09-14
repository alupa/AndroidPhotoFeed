package edu.galileo.android.photofeed.libs.base;

/**
 * Created by Alvaro on 30-06-2016.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
