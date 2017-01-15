package com.example.android101.vidstream;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Ong Heng Gnee on 14-Jan-17.
 */

// This allows the device to receive notification while running in the background
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    //tokens expires every one hour therefore we need to have a way
    // to retrieve the new token every time there is an update to the token
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", token);
        sendRegistrationToServer(token);
    }
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }

}
