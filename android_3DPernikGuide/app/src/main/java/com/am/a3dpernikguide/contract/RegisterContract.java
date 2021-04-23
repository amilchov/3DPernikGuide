package com.am.a3dpernikguide.contract;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * A contract that connects the different parts of the MVP architecture. This is the part for Registration functionality
 */
public interface RegisterContract {

    //View interface - RegisterActivity.java
    interface View {
        void showProgress();
        void hideProgress();
        void showErrorName(String errorMessage);
        void showErrorSecondName(String errorMessage);
        void showErrorLastName(String errorMessage);
        void showErrorEmail(String errorMessage);
        void showErrorPassword(String errorMessage);
        void showErrorPasswordConfirm(String errorMessage);
        void onSuccess();
        void onFailure(String errorMessage);
    }

    //Presenter interface - RegisterPresenter.java
    interface Presenter {
        void validateCredentials(String name,
                                 String secondName,
                                 String lastName,
                                 String email,
                                 String password,
                                 String passwordConfirm);
    }

    //Interactor(Model) interface - RegisterInteractor.java
    interface Model {
        void registerHandler(String name,
                             String secondName,
                             String lastName,
                             String email,
                             String password,
                             String passwordConfirm);
    }
}
