package com.am.a3dpernikguide.contract.callback;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnLoginFinishedCallback {
    void onUserEmailError(String errorMessage);
    void onUserPasswordError(String errorMessage);
    void onSuccess();
    void onFailure(String errorMessage);
}
