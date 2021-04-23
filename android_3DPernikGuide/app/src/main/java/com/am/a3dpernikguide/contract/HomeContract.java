package com.am.a3dpernikguide.contract;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A contract that connects the different parts of the MVP architecture. This is the part for Home functionality
 */
public interface HomeContract {

    //View interface - HomeFragment.java
    public interface View {
        void showProgress();
        void hideProgress();
        void setUserGreetingMessage();
        void setUserFortressDataCount(String countVisit);
        void setUserFortressDataTime(String lastTimeVisit);
        void setUserMuseumDataCount(String countVisit);
        void setUserMuseumDataTime(String lastTimeVisit);
        void failedInternetConnection();
    }

    //Presenter interface - HomePresenter.java
    public interface Presenter {
        void delegate();
    }

    //Interactor(Model) interface - HomeInteractor.java
    public interface Model {
        void dataDelegateManager();
    }

}
