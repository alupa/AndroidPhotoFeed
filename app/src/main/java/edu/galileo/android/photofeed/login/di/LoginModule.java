package edu.galileo.android.photofeed.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.login.LoginInteractor;
import edu.galileo.android.photofeed.login.LoginInteractorImpl;
import edu.galileo.android.photofeed.login.LoginPresenter;
import edu.galileo.android.photofeed.login.LoginPresenterImpl;
import edu.galileo.android.photofeed.login.LoginRepository;
import edu.galileo.android.photofeed.login.LoginRepositoryImpl;
import edu.galileo.android.photofeed.login.ui.LoginView;

/**
 * Created by Alvaro on 30-06-2016.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginInteractor loginInteractor, LoginView loginView) {
        return new LoginPresenterImpl(eventBus, loginInteractor, loginView);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    /*@Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }*/

    @Provides @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseAPI firebase) {
        return new LoginRepositoryImpl(eventBus, firebase);
    }
}
