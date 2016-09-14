package edu.galileo.android.photofeed.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.libs.base.EventBus;
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

/**
 * Created by Alvaro on 04-07-2016.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(FragmentManager fragmentManager, Fragment[] fragments, String[] titles, MainView view) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
        this.titles = titles;
        this.view = view;
    }

    @Provides
    @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(EventBus eventBus, SessionInteractor sessionInteractor, UploadInteractor uploadInteractor, MainView view) {
        return new MainPresenterImpl(eventBus, sessionInteractor, uploadInteractor, view);
    }

    @Provides @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides @Singleton
    MainSectionsPagerAdapter providesAdapter(FragmentManager fm, Fragment[] fragments, String[] titles){
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides @Singleton
    FragmentManager providesAdapterFragmentManager(){
        return this.fragmentManager;
    }

    @Provides @Singleton
    Fragment[] providesFragmentArrayForAdapter(){
        return this.fragments;
    }

    @Provides @Singleton
    String[] providesStringArrayForAdapter(){
        return this.titles;
    }

}
