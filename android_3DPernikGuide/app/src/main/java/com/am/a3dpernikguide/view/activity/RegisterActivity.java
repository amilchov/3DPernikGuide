package com.am.a3dpernikguide.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.am.a3dpernikguide.contract.RegisterContract;
import com.am.a3dpernikguide.databinding.ActivityRegisterBinding;
import com.am.a3dpernikguide.databinding.LayoutRegisterBinding;
import com.am.a3dpernikguide.presenter.RegisterPresenter;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialog;
import static com.am.a3dpernikguide.util.component.ComponentUtils.showToast;
import static com.am.a3dpernikguide.util.manager.DataManager.OK;
import static com.am.a3dpernikguide.util.manager.DataManager.SUCCESS_CREATE_USER;
import static com.am.a3dpernikguide.util.manager.DataManager.WAIT;
import static com.am.a3dpernikguide.util.manager.DataManager.WARNING;

/**
 * @author Created by Aleks Vasilev Milchov
 */

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    //Fields
    private ActivityRegisterBinding binding;
    private LayoutRegisterBinding registerBinding;
    private RegisterPresenter presenter;
    private CompositeDisposable compositeDisposable;
    private ProgressDialog progressDialog;

    /**
     * central point for the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        compositeDisposable = new CompositeDisposable();
        progressDialog = new ProgressDialog(this);
        presenter = new RegisterPresenter(this, compositeDisposable);

        registerBinding = binding.layoutRegister;
        registerBinding.btnRegister.setOnClickListener(this::onClick);
        registerBinding.tvSignIn.setOnClickListener(this::textClickListener);
    }

    //When click the button delegate with presenter
    public void onClick(View view) {
        String name = registerBinding.etFirstName.getText().toString().trim();
        String secondName = registerBinding.etSecondName.getText().toString().trim();
        String lastName = registerBinding.etSurname.getText().toString().trim();
        String email = registerBinding.etEmail.getText().toString().trim();
        String password = registerBinding.etPassword.getText().toString().trim();
        String passwordConfirm = registerBinding.etPasswordConfirm.getText().toString().trim();

        presenter.validateCredentials(name, secondName, lastName, email, password, passwordConfirm);
    }

    private void textClickListener(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showProgress() {
        progressDialog.setMessage(WAIT);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.cancel();
    }

    @Override
    public void showErrorName(String errorMessage) {
        registerBinding.etFirstName.setError(errorMessage);
        registerBinding.etFirstName.requestFocus();
    }

    @Override
    public void showErrorSecondName(String errorMessage) {
        registerBinding.etSecondName.setError(errorMessage);
        registerBinding.etSecondName.requestFocus();
    }

    @Override
    public void showErrorLastName(String errorMessage) {
        registerBinding.etSurname.setError(errorMessage);
        registerBinding.etSurname.requestFocus();
    }

    @Override
    public void showErrorEmail(String errorMessage) {
        registerBinding.etEmail.setError(errorMessage);
        registerBinding.etEmail.requestFocus();
    }

    @Override
    public void showErrorPassword(String errorMessage) {
        registerBinding.etPassword.setError(errorMessage);
        registerBinding.etPassword.requestFocus();
    }

    @Override
    public void showErrorPasswordConfirm(String errorMessage) {
        registerBinding.etPasswordConfirm.setError(errorMessage);
        registerBinding.etPasswordConfirm.requestFocus();
    }

    @Override
    public void onSuccess() {
        showToast(getApplicationContext(), SUCCESS_CREATE_USER);
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onFailure(String errorMessage) {
        showAlertDialog(this, WARNING, errorMessage, OK);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
