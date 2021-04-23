package com.am.a3dpernikguide.handler.api;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.contract.callback.api.OnScannerApiCallback;
import com.am.a3dpernikguide.handler.api.interfaces.IScannerApiHandler;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.am.a3dpernikguide.util.component.ComponentUtils.getTimeAndDateNow;
import static com.am.a3dpernikguide.util.component.ComponentUtils.getTimeNow;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class ScannerApiHandler implements IScannerApiHandler {

    private OnScannerApiCallback callback;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    private String token, count, visit;

    public ScannerApiHandler(OnScannerApiCallback callback, CompositeDisposable compositeDisposable) {
        this.callback = callback;
        this.compositeDisposable = compositeDisposable;
        apiService = ApiUtils.getService();
    }

    @Override
    public void createMuseumRequest() {
        token = SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext());
        count = String.valueOf(Integer.parseInt(SharedPreferencesManager.getUserMuseumCount(PernikGuideApplication.getContext())) + 1);
        visit = getTimeAndDateNow();
        compositeDisposable.add(
                apiService.updateMuseumData(token, count, visit, getTimeNow())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponseUpdateMuseum, throwable -> {})
        );
    }

    @Override
    public void createFortressRequest() {
        token = SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext());
        count = String.valueOf(Integer.parseInt(SharedPreferencesManager.getUserFortressCount(PernikGuideApplication.getContext())) + 1);
        visit = getTimeAndDateNow();
        compositeDisposable.add(
                apiService.updateFortressData(token, count, visit, getTimeNow())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponseUpdateFortress, throwable -> {})
        );
    }

    private void handleResponseUpdateMuseum(Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            int count = Integer.parseInt(this.count);
            SharedPreferencesManager.setUserMuseumCount(PernikGuideApplication.getContext(), String.valueOf(count));
            SharedPreferencesManager.setUserMuseumLastVisit(PernikGuideApplication.getContext(),getTimeAndDateNow());

            callback.onSuccess("Подземен минен музей");
        }
    }

    private void handleResponseUpdateFortress(Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            int count = Integer.parseInt(this.count);
            SharedPreferencesManager.setUserFortressCount(PernikGuideApplication.getContext(), String.valueOf(count));
            SharedPreferencesManager.setUserFortressLastVisit(PernikGuideApplication.getContext(),getTimeAndDateNow());

            callback.onSuccess("Средновековна пернишка крепост");
        }
    }

}
