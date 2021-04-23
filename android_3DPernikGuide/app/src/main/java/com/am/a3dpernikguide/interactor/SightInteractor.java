package com.am.a3dpernikguide.interactor;

import com.am.a3dpernikguide.contract.SightContract;
import com.am.a3dpernikguide.contract.callback.OnSightFinishedCallback;
import com.am.a3dpernikguide.contract.callback.api.OnSightApiCallback;
import com.am.a3dpernikguide.handler.api.SightApiHandler;
import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class SightInteractor implements SightContract.Model, OnSightApiCallback {

    private OnSightFinishedCallback callback;
    private SightApiHandler apiHandler;

    public SightInteractor(OnSightFinishedCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        apiHandler = new SightApiHandler(this, compositeDisposable);
    }

    @Override
    public void dataDelegateManagerMuseum() {
        apiHandler.createRequestMuseum();
    }

    @Override
    public void dataDelegateManagerFortress() {
        apiHandler.createRequestFortress();
    }

    @Override
    public void onSuccessMuseum(String count, String time, List<BarChartDataMuseum> data) {
        callback.museumData(count, time, data);
    }

    @Override
    public void onSuccessFortress(String count, String time, List<BarChatDataFortress> data) {
        callback.fortressData(count, time, data);
    }
}
