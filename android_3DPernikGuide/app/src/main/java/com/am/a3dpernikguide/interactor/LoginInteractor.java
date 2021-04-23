package com.am.a3dpernikguide.interactor;

import android.util.Patterns;

import com.am.a3dpernikguide.contract.LoginContract;
import com.am.a3dpernikguide.contract.callback.OnLoginFinishedCallback;
import com.am.a3dpernikguide.contract.callback.api.OnLoginApiCallBack;
import com.am.a3dpernikguide.contract.callback.preferences.OnLoginPreferencesCallback;
import com.am.a3dpernikguide.handler.api.LoginApiHandler;
import com.am.a3dpernikguide.handler.preferences.LoginPreferencesHandler;
import com.google.common.base.Strings;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.manager.DataManager.EMPTY_FIELD;
import static com.am.a3dpernikguide.util.manager.DataManager.INVALID_EMAIL;
import static com.am.a3dpernikguide.util.manager.DataManager.PASSWORD_FIELD_VALIDATION_NUMBER;
import static com.am.a3dpernikguide.util.manager.DataManager.containingCharacters;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class LoginInteractor implements LoginContract.Model,
        OnLoginApiCallBack, OnLoginPreferencesCallback {

    private OnLoginFinishedCallback callback;
    private LoginApiHandler apiHandler;
    private LoginPreferencesHandler preferencesHandler;

    public LoginInteractor(OnLoginFinishedCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        apiHandler = new LoginApiHandler(this, compositeDisposable);
        preferencesHandler = new LoginPreferencesHandler(this);
    }

    @Override
    public void loginHandler(String email, String password) {
        if (Strings.isNullOrEmpty(email))
            callback.onUserEmailError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(password))
            callback.onUserPasswordError(EMPTY_FIELD);
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            callback. onUserEmailError(INVALID_EMAIL);
        else if (password.length() <= PASSWORD_FIELD_VALIDATION_NUMBER)
            callback.onUserPasswordError(containingCharacters(PASSWORD_FIELD_VALIDATION_NUMBER));
        else
            apiHandler.createRequest(email, password);
    }

    @Override
    public void onSuccessApi(List<String> userData) {
        preferencesHandler.divisionData(userData);
    }

    @Override
    public void onFailure(String errorMessage) {
        callback.onFailure(errorMessage);
    }

    @Override
    public void onSuccess() {
        callback.onSuccess();
    }
}
