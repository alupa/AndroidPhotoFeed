package edu.galileo.android.photofeed.photolist;

import android.view.View;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.photolist.events.PhotoListEvent;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;

/**
 * Created by Alvaro on 04-07-2016.
 */
public class PhotoListPresenterImpl implements PhotoListPresenter {
    private EventBus eventBus;
    private PhotoListView view;
    private PhotoListInteractor interactor;
    private static final String EMPTY_LIST = "Listado vacío";

    public PhotoListPresenterImpl(EventBus eventBus, PhotoListInteractor interactor, PhotoListView view) {
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
    public void subscribe() {
        if (view != null){
            view.hideList();
            view.hideProgress();
        }
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        interactor.removePhoto(photo);
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoListEvent event) {
        if (view != null){
            view.hideProgress();
            view.showList();
        }
        String error = event.getError();
        if (error != null){
            if(error.isEmpty()){
                view.onPhotosError(EMPTY_LIST);
            } else {
                view.onPhotosError(error);
            }
        } else {
            if (event.getType() == PhotoListEvent.READ_EVENT) {
                view.addPhoto(event.getPhoto());
            } else if (event.getType() == PhotoListEvent.DELETE_EVENT) {
                view.removePhoto(event.getPhoto());
            }
        }
    }
}
