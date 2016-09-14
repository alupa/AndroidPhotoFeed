package edu.galileo.android.photofeed.photolist;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.photolist.events.PhotoListEvent;

/**
 * Created by Alvaro on 04-07-2016.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
}
