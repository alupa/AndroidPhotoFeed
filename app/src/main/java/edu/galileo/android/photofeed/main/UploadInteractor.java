package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by Alvaro on 01-07-2016.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
