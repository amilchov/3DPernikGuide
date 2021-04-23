package com.am.a3dpernikguide.handler.api;

import com.am.a3dpernikguide.contract.callback.api.OnLoginApiCallBack;
import com.am.a3dpernikguide.handler.api.interfaces.ILoginApiHandler;
import com.am.a3dpernikguide.model.api.User;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;

import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static com.am.a3dpernikguide.util.manager.DataManager.INVALID_DATA;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class LoginApiHandler implements ILoginApiHandler {

    //Fields
    private OnLoginApiCallBack callBack;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    //constructor
    public LoginApiHandler(OnLoginApiCallBack callBack, CompositeDisposable compositeDisposable) {
        this.callBack = callBack;
        this.compositeDisposable = compositeDisposable;
        apiService = ApiUtils.getService();
    }

    //Create request
    @Override
    public void createRequest(String email, String password) {
        compositeDisposable.add(
                apiService.loginUser(email, password)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, throwable -> {})
        );
    }

    private void handleResponse(Response<User> response) {
        if (response.isSuccessful()) {
            String firstName = response.body().getFirstName();
            String middleName = response.body().getMiddleName();
            String lastName = response.body().getLastName();
            String email = response.body().getEmail();
            String token = response.body().getToken();

            List<String> userData = Arrays.asList(firstName, middleName, lastName, email, token);
            callBack.onSuccessApi(userData);
        } else {
            callBack.onFailure(INVALID_DATA);
        }
    }
}
