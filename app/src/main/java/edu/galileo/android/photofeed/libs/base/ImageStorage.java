package edu.galileo.android.photofeed.libs.base;

import java.io.File;

/**
 * Created by Alvaro on 30-06-2016.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
