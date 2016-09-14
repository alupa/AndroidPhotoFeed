package edu.galileo.android.photofeed.main.ui;

/**
 * Created by Alvaro on 01-07-2016.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
