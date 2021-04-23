package com.am.a3dpernikguide.interactor;

import com.am.a3dpernikguide.contract.HomeContract;
import com.am.a3dpernikguide.contract.callback.OnHomeFinishedCallback;
import com.am.a3dpernikguide.contract.callback.api.OnHomeApiCallBack;
import com.am.a3dpernikguide.handler.api.HomeApiHandler;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.manager.DataManager.EMPTY_COUNT;
import static com.am.a3dpernikguide.util.manager.DataManager.EMPTY_TIME_VISIT;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class HomeInteractor implements HomeContract.Model, OnHomeApiCallBack {

    //Fields
    private OnHomeFinishedCallback callback;
    private HomeApiHandler apiHandler;

    //Constructor
    public HomeInteractor(OnHomeFinishedCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        apiHandler = new HomeApiHandler(this, compositeDisposable);
    }

    @Override
    public void dataDelegateManager() {
        apiHandler.createRequest();
    }

    @Override
    public void onSuccessFortress(String fortressCount, String fortressTime) {
        callback.fortressDataCount(fortressCount);
        callback.fortressDataTime(fortressTime);
    }

    @Override
    public void onSuccessMuseum(String museumCount, String museumTime) {
        callback.museumDataCount(museumCount);
        callback.museumDataTime(museumTime);
        callback.hideProgress();
    }

    @Override
    public void onFailureFortress() {
        callback.fortressDataCount(EMPTY_COUNT);
        callback.fortressDataTime(EMPTY_TIME_VISIT);
    }

    @Override
    public void onFailureMuseum() {
        callback.museumDataCount(EMPTY_COUNT);
        callback.museumDataTime(EMPTY_TIME_VISIT);
        callback.hideProgress();
    }
}
