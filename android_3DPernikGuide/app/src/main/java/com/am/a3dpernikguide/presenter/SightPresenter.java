package com.am.a3dpernikguide.presenter;

import com.am.a3dpernikguide.contract.SightContract;
import com.am.a3dpernikguide.contract.callback.OnSightFinishedCallback;
import com.am.a3dpernikguide.interactor.SightInteractor;
import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;
import com.am.a3dpernikguide.util.service.NetworkUtil;
import com.am.a3dpernikguide.view.fragment.SightFragment;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class SightPresenter implements SightContract.Presenter, OnSightFinishedCallback {

    private SightFragment view;
    private SightInteractor interactor;

    public SightPresenter(SightFragment view, CompositeDisposable compositeDisposable) {
        this.view = view;
        this.interactor = new SightInteractor(this, compositeDisposable);
    }

    @Override
    public void delegateMuseum() {
        if(!NetworkUtil.isConnectedToInterent(view.getContext())){
            view.failedInternetConnection();
        } else {
            interactor.dataDelegateManagerMuseum();
        }
    }

    @Override
    public void delegateFortress() {
        if(!NetworkUtil.isConnectedToInterent(view.getContext())){
            view.failedInternetConnection();
        } else {
            interactor.dataDelegateManagerFortress();
        }
    }

    @Override
    public void hideProgress() {
        view.hideProgress();
    }

    @Override
    public void fortressData(String count, String time, List<BarChatDataFortress> data) {
        view.setDataFortress(count, time, data);
        hideProgress();
    }

    @Override
    public void museumData(String count, String time, List<BarChartDataMuseum> data) {
        view.setDataMuseum(count, time, data);
        hideProgress();
    }
}
