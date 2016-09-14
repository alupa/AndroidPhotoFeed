package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by Alvaro on 01-07-2016.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
