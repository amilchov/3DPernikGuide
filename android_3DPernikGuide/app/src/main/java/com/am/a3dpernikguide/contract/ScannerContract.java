package com.am.a3dpernikguide.contract;

import com.google.zxing.Result;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A contract that connects the different parts of the MVP architecture. This is the part for Scanning functionality
 */
public interface ScannerContract {

    //View interface - ScannerActivity.java
    public interface View {
        void onSuccess(String text);
        void startModelActivity(Result result);
        void failedInternetConnection();
    }

    //Presenter interface - ScannerPresenter.java
    public interface Presenter {
        void delegateMuseum();
        void delegateFortress();
    }

    //Interactor(Model) interface - ScannerInteractor.java
    public interface Model {
        void dataDelegateManagerMuseum();
        void dataDelegateManagerFortress();
    }
}
