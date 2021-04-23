package com.am.a3dpernikguide.interactor;

import android.util.Patterns;

import com.am.a3dpernikguide.contract.RegisterContract;
import com.am.a3dpernikguide.contract.callback.OnRegisterFinishedCallback;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;
import com.google.common.base.Strings;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.am.a3dpernikguide.util.manager.DataManager.*;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class RegisterInteractor implements RegisterContract.Model {

    //Fields
    private ApiService apiService;
    private OnRegisterFinishedCallback callback;
    private CompositeDisposable compositeDisposable;

    //constructor
    public RegisterInteractor(OnRegisterFinishedCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        this.compositeDisposable = compositeDisposable;
        apiService = ApiUtils.getService();
    }

    //method for validation
    @Override
    public void registerHandler(String name, String secondName, String lastName,
                      String email, String password, String passwordConfirm) {
        if (Strings.isNullOrEmpty(name))
            callback.onUserNameError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(secondName))
            callback.onUserSecondNameError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(lastName))
            callback.onUserLastNameError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(email))
            callback.onUserEmailError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(password))
            callback.onUserPasswordError(EMPTY_FIELD);
        else if (Strings.isNullOrEmpty(passwordConfirm))
            callback.onUserPasswordError(EMPTY_FIELD);
        else if (name.length() <= NAME_FIELD_VALIDATION_NUMBER)
            callback.onUserNameError(containingCharacters(NAME_FIELD_VALIDATION_NUMBER));
        else if (secondName.length() <= NAME_FIELD_VALIDATION_NUMBER)
            callback.onUserSecondNameError(containingCharacters(NAME_FIELD_VALIDATION_NUMBER));
        else if (lastName.length() <= NAME_FIELD_VALIDATION_NUMBER)
            callback.onUserLastNameError(containingCharacters(NAME_FIELD_VALIDATION_NUMBER));
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            callback. onUserEmailError(INVALID_EMAIL);
        else if (password.length() <= PASSWORD_FIELD_VALIDATION_NUMBER)
            callback.onUserPasswordError(containingCharacters(PASSWORD_FIELD_VALIDATION_NUMBER));
        else if (passwordConfirm.length() <= PASSWORD_FIELD_VALIDATION_NUMBER)
            callback.onUserPasswordConfirmError(containingCharacters(PASSWORD_FIELD_VALIDATION_NUMBER));
        else if (!password.equals(passwordConfirm))
            callback.onUserPasswordError(PASS_NOT_MATCH);
        else
            createRequest(name, secondName, lastName, email, password);
    }

    //create request to the server
    private void createRequest(String firstName, String middleName, String lastName, String email, String password) {
        compositeDisposable.add(
                apiService.createUser(firstName, middleName, lastName, email, password)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, throwable -> {})
        );
    }

    //check for the response
    private void handleResponse(Response<ResponseBody> userResponse) {
        if (userResponse.isSuccessful())
            callback.onSuccess();
        else if (userResponse.code() == 422)
            callback.onFailure(EXIST_EMAIL);
        else
            callback.onFailure(WRONG_ERROR);
    }
}
