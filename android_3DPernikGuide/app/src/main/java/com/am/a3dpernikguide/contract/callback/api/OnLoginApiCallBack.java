package com.am.a3dpernikguide.contract.callback.api;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnLoginApiCallBack {
    void onSuccessApi(List<String> userData);
    void onFailure(String errorMessage);
}