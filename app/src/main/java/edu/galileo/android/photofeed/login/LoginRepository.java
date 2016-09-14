package edu.galileo.android.photofeed.login;

/**
 * Created by Alvaro on 09-06-2016.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
}
