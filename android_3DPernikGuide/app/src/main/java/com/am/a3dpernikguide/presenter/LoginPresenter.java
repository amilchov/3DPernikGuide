package com.am.a3dpernikguide.presenter;

import com.am.a3dpernikguide.contract.LoginContract;
import com.am.a3dpernikguide.contract.callback.OnLoginFinishedCallback;
import com.am.a3dpernikguide.interactor.LoginInteractor;
import com.am.a3dpernikguide.util.service.NetworkUtil;
import com.am.a3dpernikguide.view.activity.LoginActivity;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.manager.DataManager.REQUIRED_NETWORK;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class LoginPresenter implements LoginContract.Presenter, OnLoginFinishedCallback {

    private LoginActivity view;
    private LoginInteractor interactor;

    public LoginPresenter(LoginActivity view, CompositeDisposable compositeDisposable) {
        this.view = view;
        interactor = new LoginInteractor(this, compositeDisposable);
    }

    @Override
    public void validateCredentials(String email, String password) {
        if(NetworkUtil.isConnectedToInterent(view.getApplicationContext())){
            view.showProgress();
            interactor.loginHandler(email, password);
        } else {
            view.onFailure(REQUIRED_NETWORK);
        }
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
