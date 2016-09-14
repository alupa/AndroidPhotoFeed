package edu.galileo.android.photofeed.photomap;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.photomap.events.PhotoMapEvent;

/**
 * Created by Alvaro on 04-07-2016.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);

}
