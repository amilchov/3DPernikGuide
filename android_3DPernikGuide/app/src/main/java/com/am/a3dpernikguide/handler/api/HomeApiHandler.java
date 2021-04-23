package com.am.a3dpernikguide.handler.api;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.contract.callback.api.OnHomeApiCallBack;
import com.am.a3dpernikguide.handler.api.interfaces.IHomeApiHandler;
import com.am.a3dpernikguide.model.api.sights.fortress.UserDataFortressVisited;
import com.am.a3dpernikguide.model.api.sights.museum.UserDataMuseumVisited;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import java.text.NumberFormat;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class HomeApiHandler implements IHomeApiHandler {

    private OnHomeApiCallBack callBack;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    /**
     * constructor
     * @param callBack
     * @param compositeDisposable
     */
    public HomeApiHandler(OnHomeApiCallBack callBack, CompositeDisposable compositeDisposable) {
        this.callBack = callBack;
        this.compositeDisposable = compositeDisposable;
        apiService = ApiUtils.getService();
    }

    //Create request to server
    @Override
    public void createRequest() {
        compositeDisposable.add(
                apiService.userDataFortress(SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleFortressResponse, throwable -> {})
        );

        compositeDisposable.add(
                apiService.userDataMuseum(SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleMuseumResponse, throwable -> {})
        );
    }

    private void handleFortressResponse(Response<UserDataFortressVisited> response) {
        if (response.isSuccessful()) {
            Object fortressCount = response.body().getFortress().getCountFortress();
            Object fortressTime = response.body().getFortress().getLastVisitFortress();

            if (fortressCount == null || fortressTime == null)
                callBack.onFailureFortress();
            else {
                NumberFormat nf = NumberFormat.getNumberInstance();
                nf.setMaximumFractionDigits(0);
                String fortress_rounded = nf.format(fortressCount);
                callBack.onSuccessFortress(fortress_rounded, fortressTime.toString());
            }


        }
    }

    private void handleMuseumResponse(Response<UserDataMuseumVisited> response) {
        if (response.isSuccessful()) {
            Object museumCount = response.body().getMuseum().getCountMuseum();
            Object museumTime = response.body().getMuseum().getLastVisitMuseum();

            if (museumCount == null || museumTime == null)
                callBack.onFailureMuseum();
            else {
                NumberFormat nf = NumberFormat.getNumberInstance();
                nf.setMaximumFractionDigits(0);
                String museum_rounded = nf.format(museumCount);
                callBack.onSuccessMuseum(museum_rounded, museumTime.toString());
            }
        }
    }
}
