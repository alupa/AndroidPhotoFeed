package edu.galileo.android.photofeed.login;

/**
 * Created by Alvaro on 09-06-2016.
 */
public interface LoginInteractor {
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
