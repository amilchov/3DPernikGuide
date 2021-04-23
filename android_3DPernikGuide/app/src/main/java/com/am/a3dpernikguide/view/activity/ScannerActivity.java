package com.am.a3dpernikguide.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.contract.ScannerContract;
import com.am.a3dpernikguide.databinding.ActivityScannerBinding;
import com.am.a3dpernikguide.db.ModelDao;
import com.am.a3dpernikguide.db.PernikGuideDatabase;
import com.am.a3dpernikguide.graphics.view.ModelActivity;
import com.am.a3dpernikguide.presenter.ScannerPresenter;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;
import com.budiyev.android.codescanner.CodeScanner;
import com.google.zxing.Result;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialog;
import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialogScannerError;
import static com.am.a3dpernikguide.util.component.ComponentUtils.showToast;
import static com.am.a3dpernikguide.util.manager.DataManager.ERROR;
import static com.am.a3dpernikguide.util.manager.DataManager.OK;
import static com.am.a3dpernikguide.util.manager.DataManager.REQUIRED_NETWORK;
import static com.am.a3dpernikguide.util.manager.DataManager.WARNING;

/**
 * @author Created by Aleks Vasilev Milchov
 */

public class ScannerActivity extends AppCompatActivity implements ScannerContract.View {

    //View binding library
    private ActivityScannerBinding binding;
    //Code Scanner object
    private CodeScanner mCodeScanner;
    //database field
    private PernikGuideDatabase database;
    private ScannerPresenter presenter;
    //all request to the local database
    private ModelDao modelDao;
    //RxJava async
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set back arrow to ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Скенер за 3D модели!");

        //create all instances
        database = PernikGuideDatabase.getDatabase(PernikGuideApplication.getContext());
        modelDao = database.modelDao();
        compositeDisposable = new CompositeDisposable();
        presenter = new ScannerPresenter(this, compositeDisposable);

        mCodeScanner = new CodeScanner(this, binding.scannerView);
        mCodeScanner.setDecodeCallback(this::scannerCallback);

        binding.scannerView.setOnClickListener(view -> mCodeScanner.startPreview());
    }

    //callback for scanner which run on UI thread
    private void scannerCallback(Result result) {
        this.runOnUiThread(() -> {
            if (modelDao.getModel(result.getText()) == null) {
                showAlertDialogScannerError(this, ERROR, "Грешен код!", OK, mCodeScanner);
            } else {
                if (modelDao.getModel(result.getText()).getType().equals("museum")) {
                    presenter.delegateMuseum();
                    modelDao.updateModelVisited(result.getText(), SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()));
                    startModelActivity(result);
                } else if (modelDao.getModel(result.getText()).getType().equals("fortress")) {
                    presenter.delegateFortress();
                    modelDao.updateModelVisited(result.getText(), SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()));
                    startModelActivity(result);
                }
            }
            mCodeScanner.stopPreview();
        });
    }

    //if the scanning is success
    @Override
    public void onSuccess(String text) {
        showToast(this, "Успешно посетихте забележителността! - " + text + "!");
    }

    //start ModelActivity
    @Override
    public void startModelActivity(Result result) {
        Bundle bundle = new Bundle();
        bundle.putString("uri", modelDao.getModel(result.getText()).getPath());
        Intent intent = new Intent(this, ModelActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //if not exist network
    @Override
    public void failedInternetConnection() {
        showAlertDialog(this, WARNING, REQUIRED_NETWORK, OK);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //on back pressed method
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
