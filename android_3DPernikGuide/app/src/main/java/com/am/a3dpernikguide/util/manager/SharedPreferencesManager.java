package com.am.a3dpernikguide.util.manager;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.am.a3dpernikguide.util.manager.DataManager.COUNT_FORTRESS;
import static com.am.a3dpernikguide.util.manager.DataManager.COUNT_MUSEUM;
import static com.am.a3dpernikguide.util.manager.DataManager.EMAIL;
import static com.am.a3dpernikguide.util.manager.DataManager.FIRST_NAME;
import static com.am.a3dpernikguide.util.manager.DataManager.LAST_NAME;
import static com.am.a3dpernikguide.util.manager.DataManager.LAST_VISIT_FORTRESS;
import static com.am.a3dpernikguide.util.manager.DataManager.LAST_VISIT_MUSEUM;
import static com.am.a3dpernikguide.util.manager.DataManager.PREF_NAME;
import static com.am.a3dpernikguide.util.manager.DataManager.PREF_NAME_USER_DATA;
import static com.am.a3dpernikguide.util.manager.DataManager.SECOND_NAME;
import static com.am.a3dpernikguide.util.manager.DataManager.TOKEN;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class SharedPreferencesManager {

    private static SharedPreferences pref;

    public static void setUserCredentials(Context context, String firstName, String secondName,
                                          String lastName, String email, String token){
        context.getSharedPreferences(PREF_NAME,MODE_PRIVATE)
                .edit()
                .putString(FIRST_NAME, firstName)
                .putString(SECOND_NAME, secondName)
                .putString(LAST_NAME, lastName)
                .putString(EMAIL, email)
                .putString(TOKEN, token)
                .apply();
    }

    public static void setUserFortressCount(Context context, String count){
        context.getSharedPreferences(PREF_NAME_USER_DATA,MODE_PRIVATE)
                .edit()
                .putString(COUNT_FORTRESS, count)
                .apply();
    }

    public static void setUserFortressLastVisit(Context context, String visit){
        context.getSharedPreferences(PREF_NAME_USER_DATA,MODE_PRIVATE)
                .edit()
                .putString(LAST_VISIT_FORTRESS, visit)
                .apply();
    }

    public static void setUserMuseumCount(Context context, String count){
        context.getSharedPreferences(PREF_NAME_USER_DATA,MODE_PRIVATE)
                .edit()
                .putString(COUNT_MUSEUM, count)
                .apply();
    }

    public static void setUserMuseumLastVisit(Context context, String visit){
        context.getSharedPreferences(PREF_NAME_USER_DATA,MODE_PRIVATE)
                .edit()
                .putString(LAST_VISIT_MUSEUM, visit)
                .apply();
    }

    public static String getUserFortressCount(Context context) {
        pref = context.getSharedPreferences(PREF_NAME_USER_DATA, MODE_PRIVATE);
        return pref.getString(COUNT_FORTRESS, null);
    }

    public static String getUserFortressVisit(Context context) {
        pref = context.getSharedPreferences(PREF_NAME_USER_DATA, MODE_PRIVATE);
        return pref.getString(LAST_VISIT_FORTRESS, null);
    }

    public static String getUserMuseumCount(Context context) {
        pref = context.getSharedPreferences(PREF_NAME_USER_DATA, MODE_PRIVATE);
        return pref.getString(COUNT_MUSEUM, null);
    }

    public static String getUserMuseumVisit(Context context) {
        pref = context.getSharedPreferences(PREF_NAME_USER_DATA, MODE_PRIVATE);
        return pref.getString(LAST_VISIT_MUSEUM, null);
    }

    public static String getUserFirstName(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(FIRST_NAME, null);
    }

    public static String getUserSecondName(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(SECOND_NAME, null);
    }

    public static String getUserLastName(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(LAST_NAME, null);
    }

    public static String getUserEmail(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(EMAIL, null);
    }

    public static String getUserToken(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(TOKEN, null);
    }

    public static boolean isUserLogged(Context context){
        SharedPreferences credentials = getUserCredentials(context);
        return credentials != null;
    }

    private static SharedPreferences getUserCredentials(Context context){
        pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String firstName = pref.getString(FIRST_NAME, null);
        String secondName = pref.getString(SECOND_NAME, null);
        String lastName = pref.getString(LAST_NAME, null);
        String email = pref.getString(EMAIL, null);
        String token = pref.getString(TOKEN, null);

        if(firstName == null || secondName == null
                || lastName == null || email == null || token == null){
            return null;
        }
        return pref;
    }

    public static void deleteUserCredentials(Context context){
        context.getSharedPreferences(PREF_NAME,MODE_PRIVATE)
                .edit().clear().apply();
    }
}
