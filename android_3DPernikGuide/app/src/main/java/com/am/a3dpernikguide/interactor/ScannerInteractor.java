package com.am.a3dpernikguide.interactor;

import com.am.a3dpernikguide.contract.ScannerContract;
import com.am.a3dpernikguide.contract.callback.OnScannerFinishedCallback;
import com.am.a3dpernikguide.contract.callback.api.OnScannerApiCallback;
import com.am.a3dpernikguide.handler.api.ScannerApiHandler;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class ScannerInteractor implements ScannerContract.Model, OnScannerApiCallback {

    //fields
    private OnScannerFinishedCallback callback;
    private ScannerApiHandler  apiHandler;

    //cosntructor
    public ScannerInteractor(OnScannerFinishedCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        apiHandler = new ScannerApiHandler(this, compositeDisposable);
    }

    //delegate with the api handler
    @Override
    public void dataDelegateManagerMuseum() {
        apiHandler.createMuseumRequest();
    }

    //delegate with the api handler
    @Override
    public void dataDelegateManagerFortress() {
        apiHandler.createFortressRequest();
    }

    //when all is success
    @Override
    public void onSuccess(String text) {
        callback.onSuccess(text);
    }
}
