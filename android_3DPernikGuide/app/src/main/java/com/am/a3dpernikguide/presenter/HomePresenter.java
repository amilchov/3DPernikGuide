package com.am.a3dpernikguide.presenter;

import com.am.a3dpernikguide.contract.HomeContract;
import com.am.a3dpernikguide.contract.callback.OnHomeFinishedCallback;
import com.am.a3dpernikguide.interactor.HomeInteractor;
import com.am.a3dpernikguide.util.service.NetworkUtil;
import com.am.a3dpernikguide.view.fragment.HomeFragment;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class HomePresenter implements HomeContract.Presenter, OnHomeFinishedCallback {

    private HomeFragment view;
    private HomeInteractor interactor;

    public HomePresenter(HomeFragment view, CompositeDisposable compositeDisposable) {
        this.view = view;
        interactor = new HomeInteractor(this, compositeDisposable);
    }

    @Override
    public void delegate() {
        if(!NetworkUtil.isConnectedToInterent(view.getContext())){
            view.failedInternetConnection();
        } else {
            interactor.dataDelegateManager();
        }
    }

    @Override
    public void hideProgress() {
        view.hideProgress();
    }

    @Override
    public void fortressDataCount(String count) {
        view.setUserFortressDataCount(count);
    }

    @Override
    public void fortressDataTime(String visitTime) {
        view.setUserFortressDataTime(visitTime);
    }

    @Override
    public void museumDataCount(String count) {
        view.setUserMuseumDataCount(count);
    }

    @Override
    public void museumDataTime(String visitTime) {
        view.setUserMuseumDataTime(visitTime);
    }

}
