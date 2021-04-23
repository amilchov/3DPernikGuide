package com.am.a3dpernikguide;

import android.app.Application;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A global class that returns the global context of the application
 */
public class PernikGuideApplication extends Application {
    private static PernikGuideApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    //getter for the context
    public static PernikGuideApplication getContext() {
        return mContext;
    }
}
