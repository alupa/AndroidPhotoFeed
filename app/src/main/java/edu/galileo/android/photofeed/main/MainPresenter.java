package edu.galileo.android.photofeed.main;

import android.location.Location;

import edu.galileo.android.photofeed.main.events.MainEvent;

/**
 * Created by Alvaro on 01-07-2016.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void OnEventMainThread(MainEvent event);
}
