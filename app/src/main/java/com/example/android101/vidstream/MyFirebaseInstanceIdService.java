package com.example.android101.vidstream;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Ong Heng Gnee on 14-Jan-17.
 */

// This allows the device to receive notification while running in the background
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService { // register this class inside the AndroidManifest.xml file
    private static final String TAG = "myFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();       //not needed

        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        //store the necessary token
        storeToken(refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        //sendRegistrationToServer(refreshedToken);
    }
    //call the method for storing token and pass the token
    public void storeToken(String token){
        //save the token in sharedPreferences
        SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(token);
    }
}
