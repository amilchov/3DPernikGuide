package com.am.a3dpernikguide.handler.preferences;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.contract.callback.preferences.OnLoginPreferencesCallback;
import com.am.a3dpernikguide.handler.preferences.interfaces.ILoginPreferencesHandler;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class LoginPreferencesHandler implements ILoginPreferencesHandler {

    private OnLoginPreferencesCallback callback;
    private String firstName, secondName, lastName, email, token;

    public LoginPreferencesHandler(OnLoginPreferencesCallback callback) {
        this.callback = callback;
    }

    @Override
    public void divisionData(List<String> userData) {
        firstName = userData.get(0);
        secondName = userData.get(1);
        lastName = userData.get(2);
        email = userData.get(3);
        token = userData.get(4);

        safeData();
    }

    @Override
    public void safeData() {
        SharedPreferencesManager.setUserCredentials(PernikGuideApplication.getContext(),
                firstName, secondName, lastName, email, token );
        callback.onSuccess();
    }
}
