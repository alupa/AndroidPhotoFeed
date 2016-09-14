package edu.galileo.android.photofeed.photomap;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.photomap.events.PhotoMapEvent;
import edu.galileo.android.photofeed.photomap.ui.PhotoMapView;

/**
 * Created by Alvaro on 04-07-2016.
 */
public class PhotoMapPresenterImpl implements PhotoMapPresenter {
    private EventBus eventBus;
    private PhotoMapView view;
    private PhotoMapInteractor interactor;
    private static final String EMPTY_LIST = "Listado vacío";

    public PhotoMapPresenterImpl(EventBus eventBus, PhotoMapInteractor interactor, PhotoMapView view) {
        this.eventBus = eventBus;
        this.interactor = interactor;
        this.view = view;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() { interactor.subscribe(); }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoMapEvent event) {
        if(view != null){
            if(event.getError() != null){
                view.onPhotosError(event.getError());
            } else {
                if (event.getType() == PhotoMapEvent.READ_EVENT){
                    view.addPhoto(event.getPhoto());
                } else if (event.getType() == PhotoMapEvent.DELETE_EVENT){
                    view.removePhoto(event.getPhoto());
                }
            }
        }
    }
}
