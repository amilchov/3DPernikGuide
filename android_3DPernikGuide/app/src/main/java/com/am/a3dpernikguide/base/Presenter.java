package com.am.a3dpernikguide.base;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * Base class for all Presenters.
 */
public abstract class Presenter<T> {

    public Presenter(T view) {
        this.view = view;
    }

    private T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public void clearView() {
        this.view = null;
    }

}
