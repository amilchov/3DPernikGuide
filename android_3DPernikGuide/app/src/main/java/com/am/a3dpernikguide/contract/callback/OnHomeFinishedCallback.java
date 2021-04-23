package com.am.a3dpernikguide.contract.callback;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnHomeFinishedCallback {
    void hideProgress();
    void fortressDataCount(String count);
    void fortressDataTime(String visitTime);
    void museumDataCount(String count);
    void museumDataTime(String visitTime);
}
