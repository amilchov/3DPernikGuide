package com.am.a3dpernikguide.contract.callback;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnRegisterFinishedCallback {
        void onUserNameError(String errorMessage);
        void onUserSecondNameError(String errorMessage);
        void onUserLastNameError(String errorMessage);
        void onUserEmailError(String errorMessage);
        void onUserPasswordError(String errorMessage);
        void onUserPasswordConfirmError(String errorMessage);
        void onSuccess();
        void onFailure(String errorMessage);
}
