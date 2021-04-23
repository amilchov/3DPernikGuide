package com.am.a3dpernikguide.presenter;

import com.am.a3dpernikguide.contract.ScannerContract;
import com.am.a3dpernikguide.contract.callback.OnScannerFinishedCallback;
import com.am.a3dpernikguide.interactor.ScannerInteractor;
import com.am.a3dpernikguide.util.service.NetworkUtil;
import com.am.a3dpernikguide.view.activity.ScannerActivity;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class ScannerPresenter implements ScannerContract.Presenter, OnScannerFinishedCallback {

    private ScannerActivity view;
    private ScannerInteractor interactor;

    public ScannerPresenter(ScannerActivity view, CompositeDisposable compositeDisposable) {
        this.view = view;
        interactor = new ScannerInteractor(this, compositeDisposable);
    }

    @Override
    public void delegateMuseum() {
        if(!NetworkUtil.isConnectedToInterent(view.getApplicationContext())){
            view.failedInternetConnection();
        } else {
            interactor.dataDelegateManagerMuseum();
        }
    }

    @Override
    public void delegateFortress() {
        if(!NetworkUtil.isConnectedToInterent(view.getApplicationContext())){
            view.failedInternetConnection();
        } else {
            interactor.dataDelegateManagerFortress();
        }
    }

    @Override
    public void onSuccess(String text) {
        view.onSuccess(text);
    }
}
