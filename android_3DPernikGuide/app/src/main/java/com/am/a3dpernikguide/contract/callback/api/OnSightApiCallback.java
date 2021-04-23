package com.am.a3dpernikguide.contract.callback.api;

import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public interface OnSightApiCallback {
    void onSuccessMuseum(String count, String time, List<BarChartDataMuseum> data);
    void onSuccessFortress(String count, String time, List<BarChatDataFortress> data);
}
