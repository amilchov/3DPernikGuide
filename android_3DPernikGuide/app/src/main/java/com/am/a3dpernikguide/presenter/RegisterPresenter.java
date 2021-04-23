package com.am.a3dpernikguide.presenter;

import com.am.a3dpernikguide.contract.RegisterContract;
import com.am.a3dpernikguide.contract.callback.OnRegisterFinishedCallback;
import com.am.a3dpernikguide.interactor.RegisterInteractor;
import com.am.a3dpernikguide.util.service.NetworkUtil;
import com.am.a3dpernikguide.view.activity.RegisterActivity;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.manager.DataManager.*;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class RegisterPresenter implements RegisterContract.Presenter, OnRegisterFinishedCallback {

    private RegisterActivity view;
    private RegisterInteractor interactor;

    public RegisterPresenter(RegisterActivity view, CompositeDisposable compositeDisposable) {
        this.view = view;
        interactor = new RegisterInteractor(this, compositeDisposable);
    }

    @Override
    public void validateCredentials(String name, String secondName, String lastName,
                                    String email, String password, String passwordConfirm) {
        if(NetworkUtil.isConnectedToInterent(view.getApplicationContext())){
            view.showProgress();
            interactor.registerHandler(name, secondName, lastName, email, password, passwordConfirm);
        } else {
            view.onFailure(REQUIRED_NETWORK);
        }
    }

    @Override
    public void onUserNameError(String errorMessage) {
        view.hideProgress();
        view.showErrorName(errorMessage);
    }

    @Override
    public void onUserSecondNameError(String errorMessage) {
        view.hideProgress();
        view.showErrorSecondName(errorMessage);
    }

    @Override
    public void onUserLastNameError(String errorMessage) {
        view.hideProgress();
        view.showErrorLastName(errorMessage);
    }

    @Override
    public void onUserEmailError(String errorMessage) {
        view.hideProgress();
        view.showErrorEmail(errorMessage);
    }

    @Override
    public void onUserPasswordError(String errorMessage) {
        view.hideProgress();
        view.showErrorPassword(errorMessage);
    }

    @Override
    public void onUserPasswordConfirmError(String errorMessage) {
        view.hideProgress();
        view.showErrorPasswordConfirm(errorMessage);
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.onSuccess();
    }

    @Override
    public void onFailure(String errorMessage) {
        view.hideProgress();
        view.onFailure(errorMessage);
    }
}
