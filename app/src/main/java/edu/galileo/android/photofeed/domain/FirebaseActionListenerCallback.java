package edu.galileo.android.photofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by Alvaro on 29-06-2016.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
