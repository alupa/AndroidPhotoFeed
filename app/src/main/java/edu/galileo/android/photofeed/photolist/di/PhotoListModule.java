package edu.galileo.android.photofeed.photolist.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.domain.Util;
import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.libs.base.ImageLoader;
import edu.galileo.android.photofeed.libs.base.ImageStorage;
import edu.galileo.android.photofeed.main.MainPresenter;
import edu.galileo.android.photofeed.main.MainPresenterImpl;
import edu.galileo.android.photofeed.main.MainRepository;
import edu.galileo.android.photofeed.main.MainRepositoryImpl;
import edu.galileo.android.photofeed.main.SessionInteractor;
import edu.galileo.android.photofeed.main.SessionInteractorImpl;
import edu.galileo.android.photofeed.main.UploadInteractor;
import edu.galileo.android.photofeed.main.UploadInteractorImpl;
import edu.galileo.android.photofeed.main.ui.MainView;
import edu.galileo.android.photofeed.main.ui.adapters.MainSectionsPagerAdapter;
import edu.galileo.android.photofeed.photolist.PhotoListInteractor;
import edu.galileo.android.photofeed.photolist.PhotoListInteractorImpl;
import edu.galileo.android.photofeed.photolist.PhotoListPresenter;
import edu.galileo.android.photofeed.photolist.PhotoListPresenterImpl;
import edu.galileo.android.photofeed.photolist.PhotoListRepository;
import edu.galileo.android.photofeed.photolist.PhotoListRepositoryImpl;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;
import edu.galileo.android.photofeed.photolist.ui.adapters.OnItemClickListener;
import edu.galileo.android.photofeed.photolist.ui.adapters.PhotoListAdapter;

/**
 * Created by Alvaro on 04-07-2016.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoListView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListInteractor interactor, PhotoListView view) {
        return new PhotoListPresenterImpl(eventBus, interactor, view);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(EventBus eventBus, FirebaseAPI firebaseAPI) {
        return new PhotoListRepositoryImpl(eventBus, firebaseAPI);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(ImageLoader imageLoader, OnItemClickListener onItemClickListener, List<Photo> photoList, Util utils) {
        return new PhotoListAdapter(imageLoader, onItemClickListener, photoList, utils);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }
}
