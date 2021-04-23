package com.am.a3dpernikguide.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * Base Activity class for all screens.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private CompositeDisposable compositeDisposable;
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract String getToolbarTitle();

    protected abstract View getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
