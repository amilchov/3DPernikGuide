package com.am.a3dpernikguide.contract;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A contract that connects the different parts of the MVP architecture. This is the part for Login functionality
 */
public interface LoginContract {

    //View interface - LoginActivity.java
    interface View {
        void showProgress();
        void hideProgress();
        void showErrorEmail(String errorMessage);
        void showErrorPassword(String errorMessage);
        void onSuccess();
        void onFailure(String errorMessage);
    }

    //Presenter interface - LoginPresenter.java
    interface Presenter {
        void validateCredentials(String email, String password);
    }

    //Interactor(Model) interface - LoginInteractor.java
    interface Model {
        void loginHandler(String email, String password);
    }

}
