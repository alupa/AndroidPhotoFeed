package edu.galileo.android.photofeed.photomap.ui;

import edu.galileo.android.photofeed.entities.Photo;

/**
 * Created by Alvaro on 04-07-2016.
 */
public interface PhotoMapView {

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);

}
