package com.am.a3dpernikguide.handler.api;

import com.am.a3dpernikguide.contract.callback.api.OnSightApiCallback;
import com.am.a3dpernikguide.handler.api.interfaces.ISightApiHandler;
import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.fortress.Fortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;
import com.am.a3dpernikguide.model.api.sights.museum.Museum;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class SightApiHandler implements ISightApiHandler {

    //Fields
    private OnSightApiCallback callBack;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    //constructor
    public SightApiHandler(OnSightApiCallback callBack, CompositeDisposable compositeDisposable) {
        this.callBack = callBack;
        this.compositeDisposable = compositeDisposable;
        apiService = ApiUtils.getService();
    }

    @Override
    public void createRequestMuseum() {
        compositeDisposable.add(
                apiService.aggregatedDataMuseum()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponseMuseum, throwable -> {})
        );
    }

    //Create requests
    @Override
    public void createRequestFortress() {
        compositeDisposable.add(
                apiService.aggregatedDataFortress()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponseFortress, throwable -> {})
        );
    }

    private void handleResponseMuseum(Response<Museum> response) {
        if (response.isSuccessful()) {
            String visitCount = response.body().getAggregatedDataMuseum().getTotalCount();
            String timeCount = response.body().getAggregatedDataMuseum().getLastVisited();

            List<BarChartDataMuseum> data = response.body().getAggregatedDataMuseum().getBarChartDataMuseum();
            callBack.onSuccessMuseum(visitCount, timeCount, data);
        }
    }

    private void handleResponseFortress(Response<Fortress> response) {
        if (response.isSuccessful()) {
            String visitCount = response.body().getAggregatedDataFortress().getTotalCount();
            String timeCount = response.body().getAggregatedDataFortress().getLastVisited();

            List<BarChatDataFortress> data = response.body().getAggregatedDataFortress().getBarChartDataMuseum();
            callBack.onSuccessFortress(visitCount, timeCount, data);
        }
    }




}
