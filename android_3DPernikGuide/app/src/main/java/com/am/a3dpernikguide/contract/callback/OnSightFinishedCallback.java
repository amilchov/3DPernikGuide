package com.am.a3dpernikguide.contract.callback;

import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnSightFinishedCallback {
    void hideProgress();
    void fortressData(String count, String time, List<BarChatDataFortress> data);
    void museumData(String count, String time, List<BarChartDataMuseum> data);
}
