package com.am.a3dpernikguide.contract.callback.api;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnHomeApiCallBack {
    void onSuccessFortress(String fortressCount, String fortressTime);
    void onSuccessMuseum(String museumCount, String museumTime);
    void onFailureFortress();
    void onFailureMuseum();
}
