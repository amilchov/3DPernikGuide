package com.am.a3dpernikguide.contract;

import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A contract that connects the different parts of the MVP architecture. This is the part for Sight functionality
 */
public interface SightContract {

    //View interface - SightFragment.java
    public interface View {
        void setTitleActionBar();
        void setImage();
        void hideFab();
        void showFab();
        void showProgress();
        void hideProgress();
        void failedInternetConnection();
        void setDataMuseum(String count, String time, List<BarChartDataMuseum> data);
        void setDataFortress(String count, String time, List<BarChatDataFortress> data);
    }

    //Presenter interface - SightPresenter.java
    public interface Presenter {
        void delegateMuseum();
        void delegateFortress();
    }

    //Interactor(Model) interface - SightInteractor.java
    public interface Model {
        void dataDelegateManagerMuseum();
        void dataDelegateManagerFortress();
    }
}
