package edu.galileo.android.photofeed.main;

import android.location.Location;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.main.events.MainEvent;
import edu.galileo.android.photofeed.main.ui.MainView;

/**
 * Created by Alvaro on 01-07-2016.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private EventBus eventBus;
    private UploadInteractor uploadInteractor;
    private SessionInteractor sessionInteractor;

    public MainPresenterImpl(EventBus eventBus, SessionInteractor sessionInteractor, UploadInteractor uploadInteractor, MainView view) {
        this.eventBus = eventBus;
        this.sessionInteractor = sessionInteractor;
        this.uploadInteractor = uploadInteractor;
        this.view = view;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void logout() {
        sessionInteractor.logout();
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        uploadInteractor.execute(location, path);
    }

    @Override
    @Subscribe
    public void OnEventMainThread(MainEvent event) {
        String error = event.getError();
        if (this.view != null){
            switch (event.getType()){
                case MainEvent.UPLOAD_INIT:
                    view.onUploadInit();
                    break;
                case MainEvent.UPLOAD_COMPLETE:
                    view.onUploadComplete();
                    break;
                case MainEvent.UPLOAD_ERROR:
                    view.onUploadError(error);
                    break;
            }
        }
    }
}
