/**
 * Created by HenryVirus on 07-Mar-17.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by HenryVirus on 05-Mar-17.
 */

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "FCMSharedPref";
    private static final String TAG_TOKEN = "tagtoken";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager (Context context){
        mCtx = context;
    }
    public static synchronized SharedPrefManager getmInstance(Context context){     //// TODO: 05-Mar-17 understand the 'synchronized' part of the code
        if (mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will save the device token into shared preferences
    public boolean saveDeviceToken (String token){                                  //// TODO: 05-Mar-17 understand the 'sharedPreferences' part of the code
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, token);
        editor.apply();
        return true;
    }

    //this method will fetch the device token from sharedPreferences
    public String getDeviceToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TAG_TOKEN, null);
    }
}